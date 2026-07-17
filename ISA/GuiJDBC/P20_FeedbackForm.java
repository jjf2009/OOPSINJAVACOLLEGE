import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 20. Store feedback form details into database
public class P20_FeedbackForm extends JFrame {
    JTextField nameField;
    JTextArea msgArea;

    public P20_FeedbackForm() {
        setTitle("Feedback Form");
        setSize(400, 280);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(1, 2, 5, 5));
        nameField = new JTextField();
        top.add(new JLabel("Name"));
        top.add(nameField);

        msgArea = new JTextArea(5, 20);
        JButton btn = new JButton("Submit Feedback");

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(msgArea), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        btn.addActionListener(e -> save());
        setVisible(true);
    }

    void save() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO feedback(name, message) VALUES (?,?)");
            ps.setString(1, nameField.getText());
            ps.setString(2, msgArea.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Feedback saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P20_FeedbackForm(); }
}
