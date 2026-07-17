import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 2. Student registration form - insert into students table
public class P02_StudentRegistration extends JFrame {
    JTextField rollField, nameField, courseField;

    public P02_StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();
        JButton btn = new JButton("Register");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Course")); add(courseField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(roll_no, name, course) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, courseField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P02_StudentRegistration(); }
}
