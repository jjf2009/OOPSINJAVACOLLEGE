import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 15. Search employee salary using Employee ID
public class P15_SearchEmployeeSalary extends JFrame {
    JTextField idField;
    JLabel resultLabel;

    public P15_SearchEmployeeSalary() {
        setTitle("Employee Salary");
        setSize(350, 160);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        resultLabel = new JLabel("-");
        JButton btn = new JButton("Search");

        add(new JLabel("Employee ID")); add(idField);
        add(new JLabel("Salary")); add(resultLabel);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> search());
        setVisible(true);
    }

    void search() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT name, salary FROM employees WHERE id=?");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                resultLabel.setText(rs.getString("name") + " : " + rs.getDouble("salary"));
            else
                resultLabel.setText("Not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P15_SearchEmployeeSalary(); }
}
