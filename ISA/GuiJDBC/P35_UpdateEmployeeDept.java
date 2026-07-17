import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 35. Update employee department
public class P35_UpdateEmployeeDept extends JFrame {
    JTextField idField, deptField;

    public P35_UpdateEmployeeDept() {
        setTitle("Update Department");
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        deptField = new JTextField();
        JButton btn = new JButton("Update");

        add(new JLabel("Employee ID")); add(idField);
        add(new JLabel("Department")); add(deptField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> update());
        setVisible(true);
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE employees SET department=? WHERE id=?");
            ps.setString(1, deptField.getText());
            ps.setInt(2, Integer.parseInt(idField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Department updated" : "Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P35_UpdateEmployeeDept(); }
}
