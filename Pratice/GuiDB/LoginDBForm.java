import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LoginDBForm extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public LoginDBForm() {
        setTitle("Database Login");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userField = new JTextField();
        passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        add(new JLabel("Username"));
        add(userField);
        add(new JLabel("Password"));
        add(passField);
        add(new JLabel(""));
        add(loginBtn);

        loginBtn.addActionListener(e -> validateLogin());
        setVisible(true);
    }

    void validateLogin() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userField.getText());
            ps.setString(2, new String(passField.getPassword()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginDBForm();
    }
}