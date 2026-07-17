import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 19. Delete student records using Roll Number
public class P19_DeleteStudent extends JFrame {
    JTextField rollField;

    public P19_DeleteStudent() {
        setTitle("Delete Student");
        setSize(350, 150);
        setLayout(new GridLayout(2, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        JButton btn = new JButton("Delete");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> delete());
        setVisible(true);
    }

    void delete() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Deleted" : "Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P19_DeleteStudent(); }
}
