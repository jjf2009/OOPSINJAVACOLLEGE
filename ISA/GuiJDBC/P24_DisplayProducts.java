import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 24. Display all rows from products table in text area
public class P24_DisplayProducts extends JFrame {
    JTextArea area;

    public P24_DisplayProducts() {
        setTitle("All Products");
        setSize(450, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Products");
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM products");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("id")).append(" | ")
                  .append(rs.getString("name")).append(" | ")
                  .append(rs.getDouble("price")).append("\n");
            }
            area.setText(sb.length() == 0 ? "No products" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P24_DisplayProducts(); }
}
