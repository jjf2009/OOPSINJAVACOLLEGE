import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 32. Display all book titles
public class P32_DisplayBookTitles extends JFrame {
    JTextArea area;

    public P32_DisplayBookTitles() {
        setTitle("Book Titles");
        setSize(350, 280);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        JButton btn = new JButton("Load Titles");
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> load());
        setVisible(true);
    }

    void load() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT title FROM books");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) sb.append(rs.getString("title")).append("\n");
            area.setText(sb.length() == 0 ? "No books" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P32_DisplayBookTitles(); }
}
