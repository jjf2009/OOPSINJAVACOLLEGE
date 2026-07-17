import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 39. Store examination results into database
public class P39_ExamResultInsert extends JFrame {
    JTextField rollField, subjectField, marksField;

    public P39_ExamResultInsert() {
        setTitle("Exam Results");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollField = new JTextField();
        subjectField = new JTextField();
        marksField = new JTextField();
        JButton btn = new JButton("Save Result");

        add(new JLabel("Roll No")); add(rollField);
        add(new JLabel("Subject")); add(subjectField);
        add(new JLabel("Marks")); add(marksField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO exam_results(roll_no, subject, marks) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, subjectField.getText());
            ps.setInt(3, Integer.parseInt(marksField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Result saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P39_ExamResultInsert(); }
}
