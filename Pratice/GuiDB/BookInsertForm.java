import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class BookInsertForm extends JFrame {
    JTextField titleField, authorField, priceField;

    public BookInsertForm() {
        setTitle("Insert Book");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleField = new JTextField();
        authorField = new JTextField();
        priceField = new JTextField();
        JButton insertBtn = new JButton("Insert");

        add(new JLabel("Title"));
        add(titleField);
        add(new JLabel("Author"));
        add(authorField);
        add(new JLabel("Price"));
        add(priceField);
        add(new JLabel(""));
        add(insertBtn);

        insertBtn.addActionListener(e -> insertBook());
        setVisible(true);
    }

    void insertBook() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO books(title, author, price) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, titleField.getText());
            ps.setString(2, authorField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book inserted successfully");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new BookInsertForm();
    }
}