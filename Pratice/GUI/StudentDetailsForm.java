import java.awt.*;
import javax.swing.*;

public class StudentDetailsForm extends JFrame {
    JTextField nameField, rollField, courseField;

    public StudentDetailsForm() {
        setTitle("Student Details");
        setSize(350, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();
        JButton showBtn = new JButton("Show Details");

        add(new JLabel("Roll No"));
        add(rollField);
        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("Course"));
        add(courseField);
        add(new JLabel(""));
        add(showBtn);

        showBtn.addActionListener(e -> {
            String details = "Roll No: " + rollField.getText()
                    + "\nName: " + nameField.getText()
                    + "\nCourse: " + courseField.getText();
            JOptionPane.showMessageDialog(this, details);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentDetailsForm();
    }
}