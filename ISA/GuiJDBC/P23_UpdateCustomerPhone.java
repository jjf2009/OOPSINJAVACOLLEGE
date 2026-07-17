import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 23. Update customer phone number
public class P23_UpdateCustomerPhone extends JFrame {
    JTextField idField, phoneField;

    public P23_UpdateCustomerPhone() {
        setTitle("Update Customer Phone");
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        phoneField = new JTextField();
        JButton btn = new JButton("Update");

        add(new JLabel("Customer ID")); add(idField);
        add(new JLabel("New Phone")); add(phoneField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> update());
        setVisible(true);
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE customers SET phone=? WHERE id=?");
            ps.setString(1, phoneField.getText());
            ps.setInt(2, Integer.parseInt(idField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Phone updated" : "Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P23_UpdateCustomerPhone(); }
}
