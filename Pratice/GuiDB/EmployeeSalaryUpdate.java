import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class EmployeeSalaryUpdate extends JFrame {
    JTextField idField, salaryField;

    public EmployeeSalaryUpdate() {
        setTitle("Update Employee Salary");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        salaryField = new JTextField();
        JButton updateBtn = new JButton("Update");

        add(new JLabel("Employee ID"));
        add(idField);
        add(new JLabel("New Salary"));
        add(salaryField);
        add(new JLabel(""));
        add(updateBtn);

        updateBtn.addActionListener(e -> updateSalary());
        setVisible(true);
    }

    void updateSalary() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE employees SET salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, Double.parseDouble(salaryField.getText()));
            ps.setInt(2, Integer.parseInt(idField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Salary updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new EmployeeSalaryUpdate();
    }
}