import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 14. Student marks entry form - save marks to DB
public class P14_StudentMarksEntry extends JFrame {
    JTextField rollField, marksField;

    public P14_StudentMarksEntry() {
        setTitle("Marks Entry");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        marksField = new JTextField();
        JButton btn = new JButton("Save Marks");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("Marks")); add(marksField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> save());
        setVisible(true);
    }

    void save() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET marks=? WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(marksField.getText()));
            ps.setInt(2, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            if (n == 0) {
                // insert if not exists
                ps = con.prepareStatement(
                    "INSERT INTO students(roll_no, name, marks) VALUES (?,'Unknown',?)");
                ps.setInt(1, Integer.parseInt(rollField.getText()));
                ps.setInt(2, Integer.parseInt(marksField.getText()));
                ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Marks saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P14_StudentMarksEntry(); }
}
