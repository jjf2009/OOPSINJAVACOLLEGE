import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 36. Insert attendance details
public class P36_AttendanceInsert extends JFrame {
    JTextField rollField, statusField;

    public P36_AttendanceInsert() {
        setTitle("Attendance Entry");
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        statusField = new JTextField();
        JButton btn = new JButton("Save");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("Status (P/A)")); add(statusField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(roll_no, status, att_date) VALUES (?,?,CURDATE())");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, statusField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Attendance saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P36_AttendanceInsert(); }
}
