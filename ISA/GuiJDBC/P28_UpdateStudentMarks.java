import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 28. Update student marks using Roll Number
public class P28_UpdateStudentMarks extends JFrame {
    JTextField rollField, marksField;

    public P28_UpdateStudentMarks() {
        setTitle("Update Student Marks");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        marksField = new JTextField();
        JButton btn = new JButton("Update");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("Marks")); add(marksField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> update());
        setVisible(true);
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET marks=? WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(marksField.getText()));
            ps.setInt(2, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Marks updated" : "Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P28_UpdateStudentMarks(); }
}
