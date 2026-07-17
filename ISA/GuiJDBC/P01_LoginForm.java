import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 1. Swing login form - check username/password from users table
public class P01_LoginForm extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public P01_LoginForm() {
        setTitle("Login Form");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userField = new JTextField();
        passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        add(new JLabel("Username")); add(userField);
        add(new JLabel("Password")); add(passField);
        add(new JLabel("")); add(loginBtn);

        loginBtn.addActionListener(e -> login());
        setVisible(true);
    }

    void login() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, userField.getText());
            ps.setString(2, new String(passField.getPassword()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) JOptionPane.showMessageDialog(this, "Login Successful");
            else JOptionPane.showMessageDialog(this, "Invalid Credentials");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P01_LoginForm(); }
}
