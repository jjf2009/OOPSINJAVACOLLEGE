import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 6. Update student city by Roll Number
public class P06_UpdateStudentCity extends JFrame {
    JTextField rollField, cityField;

    public P06_UpdateStudentCity() {
        setTitle("Update Student City");
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        cityField = new JTextField();
        JButton btn = new JButton("Update");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("New City")); add(cityField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> update());
        setVisible(true);
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET city=? WHERE roll_no=?");
            ps.setString(1, cityField.getText());
            ps.setInt(2, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "City updated" : "Roll not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P06_UpdateStudentCity(); }
}
