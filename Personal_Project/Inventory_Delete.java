import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Inventory_Delete extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JLabel status;
    
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";

    public Inventory_Delete() {
        setTitle("Delete Material Record");
        setSize(900, 500); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };

        model.setColumnIdentifiers(new String[]{
            "ID", "Material Name", "Supplier", "Type", "Quantity", "Price", "Damaged"
        });

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);

        JButton deleteBtn = new JButton("Permanently Delete Selected");
        JButton refreshBtn = new JButton("Refresh List");
        
        deleteBtn.setBackground(new Color(180, 0, 0));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFont(new Font("SansSerif", Font.BOLD, 12));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        topPanel.add(refreshBtn);
        topPanel.add(deleteBtn);

        status = new JLabel(" Select a material row from the table below to delete.");
        status.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        deleteBtn.addActionListener(e -> deleteItem());
        refreshBtn.addActionListener(e -> loadData());

        loadData();
        setVisible(true);
    }

    void loadData() {
        String sql = "SELECT id, name, supplier, type, quantity, price, is_damaged FROM items";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{ 
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getString("supplier"),
                    rs.getString("type"),
                    rs.getInt("quantity"),
                    "$" + rs.getDouble("price"),
                    rs.getBoolean("is_damaged") ? "Yes" : "No"
                });
            }
            status.setText(" Total Items in Inventory: " + model.getRowCount());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Load Error: " + ex.getMessage());
        }
    }

    void deleteItem() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Error: Please select a material row first.");
            return;
        }

        int modelRow = table.convertRowIndexToModel(selectedRow);
        Object idValue = model.getValueAt(modelRow, 0);
        String itemName = model.getValueAt(modelRow, 1).toString();

        int confirm = JOptionPane.showConfirmDialog(this, 
            "WARNING: You are about to permanently delete '" + itemName + "'.\nThis action cannot be undone. Proceed?", 
            "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE id=?")) {

                ps.setObject(1, idValue);
                ps.executeUpdate();

                model.removeRow(modelRow);
                status.setText(" Success: '" + itemName + "' has been removed.");
                
                JOptionPane.showMessageDialog(this, "Material deleted successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inventory_Delete::new);
    }
}