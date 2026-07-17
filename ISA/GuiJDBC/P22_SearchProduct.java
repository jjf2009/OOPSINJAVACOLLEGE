import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 22. Search product details using Product ID
public class P22_SearchProduct extends JFrame {
    JTextField idField;
    JTextArea result;

    public P22_SearchProduct() {
        setTitle("Search Product");
        setSize(400, 220);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(1, 3, 5, 5));
        idField = new JTextField();
        JButton btn = new JButton("Search");
        top.add(new JLabel("Product ID"));
        top.add(idField);
        top.add(btn);

        result = new JTextArea();
        result.setEditable(false);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(result), BorderLayout.CENTER);

        btn.addActionListener(e -> search());
        setVisible(true);
    }

    void search() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM products WHERE id=?");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result.setText("ID: " + rs.getInt("id")
                    + "\nName: " + rs.getString("name")
                    + "\nPrice: " + rs.getDouble("price"));
            else
                result.setText("Product not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P22_SearchProduct(); }
}
