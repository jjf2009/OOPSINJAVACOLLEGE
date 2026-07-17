import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 9. Display all product names from database
public class P09_DisplayProductNames extends JFrame {
    JTextArea area;

    public P09_DisplayProductNames() {
        setTitle("Product Names");
        setSize(400, 300);
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
            ResultSet rs = con.createStatement().executeQuery("SELECT name FROM products");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) sb.append(rs.getString("name")).append("\n");
            area.setText(sb.length() == 0 ? "No products" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P09_DisplayProductNames(); }
}
