import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 7. Delete employee by Employee ID
public class P07_DeleteEmployee extends JFrame {
    JTextField idField;

    public P07_DeleteEmployee() {
        setTitle("Delete Employee");
        setSize(350, 150);
        setLayout(new GridLayout(2, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        JButton btn = new JButton("Delete");

        add(new JLabel("Employee ID")); add(idField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> delete());
        setVisible(true);
    }

    void delete() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM employees WHERE id=?");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Deleted" : "ID not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P07_DeleteEmployee(); }
}
