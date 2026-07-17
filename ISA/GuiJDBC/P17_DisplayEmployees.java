import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 17. Display all employee records using ResultSet
public class P17_DisplayEmployees extends JFrame {
    JTextArea area;

    public P17_DisplayEmployees() {
        setTitle("All Employees");
        setSize(450, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Employees");

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employees");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("id")).append(" | ")
                  .append(rs.getString("name")).append(" | ")
                  .append(rs.getDouble("salary")).append("\n");
            }
            area.setText(sb.length() == 0 ? "No records" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P17_DisplayEmployees(); }
}
