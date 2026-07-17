import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 27. Retrieve and display employee names
public class P27_DisplayEmployeeNames extends JFrame {
    JTextArea area;

    public P27_DisplayEmployeeNames() {
        setTitle("Employee Names");
        setSize(350, 280);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Names");
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT name FROM employees");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) sb.append(rs.getString("name")).append("\n");
            area.setText(sb.length() == 0 ? "No employees" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P27_DisplayEmployeeNames(); }
}
