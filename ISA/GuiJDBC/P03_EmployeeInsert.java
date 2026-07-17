import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 3. Add employee details (ID, Name, Salary) using JDBC
public class P03_EmployeeInsert extends JFrame {
    JTextField idField, nameField, salaryField;

    public P03_EmployeeInsert() {
        setTitle("Add Employee");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        nameField = new JTextField();
        salaryField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("ID")); add(idField);
        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Salary")); add(salaryField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employees(id, name, salary) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setDouble(3, Double.parseDouble(salaryField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee added");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P03_EmployeeInsert(); }
}
