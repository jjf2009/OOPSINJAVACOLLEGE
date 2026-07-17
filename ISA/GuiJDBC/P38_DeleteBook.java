import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 38. Delete library book using Book ID
public class P38_DeleteBook extends JFrame {
    JTextField idField;

    public P38_DeleteBook() {
        setTitle("Delete Book");
        setSize(350, 150);
        setLayout(new GridLayout(2, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        JButton btn = new JButton("Delete");

        add(new JLabel("Book ID")); add(idField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> delete());
        setVisible(true);
    }

    void delete() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM books WHERE id=?");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Book deleted" : "Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P38_DeleteBook(); }
}
