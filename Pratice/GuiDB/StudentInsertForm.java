import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StudentInsertForm extends JFrame {
    JTextField nameField, rollField, courseField;

    public StudentInsertForm() {
        setTitle("Insert Student");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();
        JButton insertBtn = new JButton("Insert");

        add(new JLabel("Roll No"));
        add(rollField);
        add(new JLabel("Name"));
        add(nameField);
        add(new JLabel("Course"));
        add(courseField);
        add(new JLabel(""));
        add(insertBtn);

        insertBtn.addActionListener(e -> insertStudent());
        setVisible(true);
    }

    void insertStudent() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students(roll_no, name, course) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, courseField.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student inserted successfully");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentInsertForm();
    }
}