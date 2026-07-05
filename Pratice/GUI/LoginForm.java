import java.awt.*;
import javax.swing.*;

public class LoginForm extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public LoginForm() {
        setTitle("Login Form");
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

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}