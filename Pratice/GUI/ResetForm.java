import java.awt.*;
import javax.swing.*;

public class ResetForm extends JFrame {
    JTextField nameField, emailField, phoneField;

    public ResetForm() {
        setTitle("Reset Form");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();

        JButton resetBtn = new JButton("Reset");

        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("Email"));
        add(emailField);
        add(new JLabel("Phone"));
        add(phoneField);
        add(new JLabel(""));
        add(resetBtn);

        resetBtn.addActionListener(e -> {
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ResetForm();
    }
}