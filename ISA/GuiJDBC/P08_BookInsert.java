import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 8. Insert book details into books table
public class P08_BookInsert extends JFrame {
    JTextField idField, titleField, priceField;

    public P08_BookInsert() {
        setTitle("Insert Book");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        titleField = new JTextField();
        priceField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Book ID")); add(idField);
        add(new JLabel("Title")); add(titleField);
        add(new JLabel("Price")); add(priceField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(id, title, price) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, titleField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book inserted");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P08_BookInsert(); }
}
