import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 37. Display all customer details
public class P37_DisplayCustomers extends JFrame {
    JTextArea area;

    public P37_DisplayCustomers() {
        setTitle("All Customers");
        setSize(450, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Customers");
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM customers");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("id")).append(" | ")
                  .append(rs.getString("name")).append(" | ")
                  .append(rs.getString("phone")).append(" | ")
                  .append(rs.getString("email")).append("\n");
            }
            area.setText(sb.length() == 0 ? "No customers" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P37_DisplayCustomers(); }
}
