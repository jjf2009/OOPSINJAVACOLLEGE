import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 4. Display all records from students table in a text area
public class P04_DisplayStudents extends JFrame {
    JTextArea area;

    public P04_DisplayStudents() {
        setTitle("All Students");
        setSize(450, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Students");

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("roll_no")).append(" | ")
                  .append(rs.getString("name")).append(" | ")
                  .append(rs.getString("course")).append("\n");
            }
            area.setText(sb.length() == 0 ? "No records" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P04_DisplayStudents(); }
}
