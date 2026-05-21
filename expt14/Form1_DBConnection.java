import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Form1_DBConnection extends JFrame {

    JTextField hostField, portField, dbField, userField, urlField;
    JPasswordField passField;
    JComboBox<String> dbType;
    JLabel statusLabel;

    public Form1_DBConnection() {

        setTitle("Database Connection Form");
        setSize(500, 400);
        setLayout(new GridLayout(8,2,10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hostField = new JTextField("localhost");
        portField = new JTextField("3306");
        dbField = new JTextField("test");
        userField = new JTextField("root");

        passField = new JPasswordField();

        dbType = new JComboBox<>(
                new String[]{"MySQL", "PostgreSQL", "SQLite"}
        );

        urlField = new JTextField();
        urlField.setEditable(false);

        statusLabel = new JLabel("Not Connected");

        JButton connectBtn = new JButton("Connect");

        add(new JLabel("Host"));
        add(hostField);

        add(new JLabel("Port"));
        add(portField);

        add(new JLabel("Database"));
        add(dbField);

        add(new JLabel("Username"));
        add(userField);

        add(new JLabel("Password"));
        add(passField);

        add(new JLabel("DB Type"));
        add(dbType);

        add(new JLabel("JDBC URL"));
        add(urlField);

        add(connectBtn);
        add(statusLabel);

        updateURL();

        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateURL(); }
            public void removeUpdate(DocumentEvent e) { updateURL(); }
            public void changedUpdate(DocumentEvent e) { updateURL(); }
        };

        hostField.getDocument().addDocumentListener(dl);
        portField.getDocument().addDocumentListener(dl);
        dbField.getDocument().addDocumentListener(dl);

        connectBtn.addActionListener(e -> connectDB());

        setVisible(true);
    }

    void updateURL() {

        String type = dbType.getSelectedItem().toString();

        String url = "";

        if(type.equals("MySQL")) {
            url = "jdbc:mysql://" +
                    hostField.getText() + ":" +
                    portField.getText() + "/" +
                    dbField.getText();
        }

        urlField.setText(url);
    }

    void connectDB() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
        urlField.getText(),
        "root",
        ""
);

            statusLabel.setText("Connection Successful");
            statusLabel.setForeground(Color.GREEN);

            con.close();

        } catch(Exception ex) {

            statusLabel.setText("Connection Failed");
            statusLabel.setForeground(Color.RED);

    ex.printStackTrace();

    JOptionPane.showMessageDialog(
            this,
            ex.getMessage()
    );
        }
    }

    public static void main(String[] args) {
        new Form1_DBConnection();
    }
}