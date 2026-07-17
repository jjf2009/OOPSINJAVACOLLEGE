import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 31. Validate admin login using database records
public class P31_AdminLogin extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public P31_AdminLogin() {
        setTitle("Admin Login");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userField = new JTextField();
        passField = new JPasswordField();
        JButton btn = new JButton("Admin Login");

        add(new JLabel("Admin User")); add(userField);
        add(new JLabel("Password")); add(passField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> login());
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
            if (rs.next())
                JOptionPane.showMessageDialog(this, "Admin login successful");
            else
                JOptionPane.showMessageDialog(this, "Access denied");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P31_AdminLogin(); }
}
