import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StudentDeleteForm extends JFrame {
    JTextField rollField;

    public StudentDeleteForm() {
        setTitle("Delete Student");
        setSize(350, 150);
        setLayout(new GridLayout(2, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        JButton deleteBtn = new JButton("Delete");

        add(new JLabel("Roll Number"));
        add(rollField);
        add(new JLabel(""));
        add(deleteBtn);

        deleteBtn.addActionListener(e -> deleteStudent());
        setVisible(true);
    }

    void deleteStudent() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE roll_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(rollField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Student not found");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentDeleteForm();
    }
}