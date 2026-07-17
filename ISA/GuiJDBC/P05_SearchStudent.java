import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 5. Search student by Roll Number
public class P05_SearchStudent extends JFrame {
    JTextField rollField;
    JTextArea result;

    public P05_SearchStudent() {
        setTitle("Search Student");
        setSize(400, 250);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(1, 3, 5, 5));
        rollField = new JTextField();
        JButton btn = new JButton("Search");
        top.add(new JLabel("Roll No"));
        top.add(rollField);
        top.add(btn);

        result = new JTextArea();
        result.setEditable(false);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(result), BorderLayout.CENTER);

        btn.addActionListener(e -> search());
        setVisible(true);
    }

    void search() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.setText("Roll: " + rs.getInt("roll_no")
                    + "\nName: " + rs.getString("name")
                    + "\nCourse: " + rs.getString("course"));
            } else {
                result.setText("Student not found");
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P05_SearchStudent(); }
}
