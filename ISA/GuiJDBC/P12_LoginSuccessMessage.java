import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 12. Login success message after validating credentials from DB
public class P12_LoginSuccessMessage extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public P12_LoginSuccessMessage() {
        setTitle("Validate Login");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userField = new JTextField();
        passField = new JPasswordField();
        JButton btn = new JButton("Validate");

        add(new JLabel("Username")); add(userField);
        add(new JLabel("Password")); add(passField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> validateUser());
        setVisible(true);
    }

    void validateUser() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, userField.getText());
            ps.setString(2, new String(passField.getPassword()));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + userField.getText());
            else
                JOptionPane.showMessageDialog(this, "Login Failed");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P12_LoginSuccessMessage(); }
}
