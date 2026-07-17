import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 16. Update book price in database
public class P16_UpdateBookPrice extends JFrame {
    JTextField idField, priceField;

    public P16_UpdateBookPrice() {
        setTitle("Update Book Price");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        priceField = new JTextField();
        JButton btn = new JButton("Update");

        add(new JLabel("Book ID")); add(idField);
        add(new JLabel("New Price")); add(priceField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> update());
        setVisible(true);
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET price=? WHERE id=?");
            ps.setDouble(1, Double.parseDouble(priceField.getText()));
            ps.setInt(2, Integer.parseInt(idField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Price updated" : "Book not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P16_UpdateBookPrice(); }
}
