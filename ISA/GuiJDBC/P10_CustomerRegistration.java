import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 10. Customer registration - store in MySQL
public class P10_CustomerRegistration extends JFrame {
    JTextField nameField, phoneField, emailField;

    public P10_CustomerRegistration() {
        setTitle("Customer Registration");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        JButton btn = new JButton("Register");

        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Phone")); add(phoneField);
        add(new JLabel("Email")); add(emailField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO customers(name, phone, email) VALUES (?,?,?)");
            ps.setString(1, nameField.getText());
            ps.setString(2, phoneField.getText());
            ps.setString(3, emailField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Customer registered");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P10_CustomerRegistration(); }
}
