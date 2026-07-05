import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class EmployeeViewer extends JFrame {
    DefaultTableModel model;

    public EmployeeViewer() {
        setTitle("Employee Records");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Department", "Salary"});

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();
        setVisible(true);
    }

    void loadData() {
        try {
            model.setRowCount(0);
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                });
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new EmployeeViewer();
    }
}