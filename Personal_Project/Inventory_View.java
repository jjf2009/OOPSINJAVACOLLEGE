import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Inventory_View extends JFrame {
    
    private JTable table;
    private DefaultTableModel model;
    private JLabel status;
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";

    public Inventory_View() {
        setTitle("Construction Material Stock Records");
        setSize(1000, 500); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };
        
        model.setColumnIdentifiers(new String[]{
            "ID", "Material Name", "Supplier", "Type", "Qty", "Price", "Damaged?", "Stock Status"
        });

        table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane sp = new JScrollPane(table);

        JButton refreshBtn = new JButton("Refresh Stock Data");
        refreshBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        status = new JLabel(" Total Records: 0");
        status.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Adding components to the frame
        add(sp, BorderLayout.CENTER);
        add(refreshBtn, BorderLayout.NORTH);
        add(status, BorderLayout.SOUTH);

        refreshBtn.addActionListener(e -> loadData());

        loadData(); 
        setVisible(true);
    }

    void loadData() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM items")) {

            model.setRowCount(0); 
            int count = 0;

            while (rs.next()) {
                int qty = rs.getInt("quantity");
               
                String stockStatus = (qty > 0) ? "Available" : "Out of Stock";
                
                String isDamaged = rs.getBoolean("is_damaged") ? "Yes" : "No";

                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("supplier"),
                    rs.getString("type"),
                    qty,
                    "$" + rs.getDouble("price"),
                    isDamaged,
                    stockStatus
                });
                count++;
            }

            status.setText(" Total Inventory Records: " + count);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Inventory_View();
    }
}