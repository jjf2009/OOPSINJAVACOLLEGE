import java.awt.*;
import java.sql.*;
import java.io.File;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Inventory_Add extends JFrame {

    // Input Components
    private JTextField nameField, supplierField, priceField;
    private JComboBox<String> typeCombo;
    private JSpinner quantitySpinner;
    private JCheckBox damagedCheck;
    private JTextArea notesArea;
    private JLabel filePathLabel;
    private File selectedInvoice;

    // Database Credentials
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";

    public Inventory_Add() {
        setTitle("Construction Material Inventory System");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel with Padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Panel (GridBagLayout for better control over components)
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        // 1. Name & Supplier
        formPanel.add(new JLabel("Material Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Supplier Name:"));
        supplierField = new JTextField();
        formPanel.add(supplierField);

        // 2. Material Type (JComboBox)
        formPanel.add(new JLabel("Material Type:"));
        String[] categories = {"Cement", "Steel", "Bricks", "Timber", "Electrical", "Plumbing"};
        typeCombo = new JComboBox<>(categories);
        formPanel.add(typeCombo);

        // 3. Quantity (JSpinner)
        formPanel.add(new JLabel("Quantity:"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10000, 1));
        formPanel.add(quantitySpinner);

        // 4. Unit Price
        formPanel.add(new JLabel("Unit Price ($):"));
        priceField = new JTextField();
        formPanel.add(priceField);

        // 5. Damaged Status (JCheckBox)
        formPanel.add(new JLabel("Condition:"));
        damagedCheck = new JCheckBox("Mark as Damaged");
        formPanel.add(damagedCheck);

        // 6. Invoice Upload (JFileChooser)
        formPanel.add(new JLabel("Invoice:"));
        JButton uploadBtn = new JButton("Choose File");
        filePathLabel = new JLabel("No file selected");
        JPanel filePanel = new JPanel(new BorderLayout());
        filePanel.add(uploadBtn, BorderLayout.WEST);
        filePanel.add(filePathLabel, BorderLayout.CENTER);
        formPanel.add(filePanel);

        // 7. Storage Notes (JTextArea)
        mainPanel.add(formPanel, BorderLayout.NORTH);
        
        JPanel notesPanel = new JPanel(new BorderLayout());
        notesPanel.add(new JLabel("Storage Area/Notes:"), BorderLayout.NORTH);
        notesArea = new JTextArea(4, 20);
        notesArea.setLineWrap(true);
        notesPanel.add(new JScrollPane(notesArea), BorderLayout.CENTER);
        mainPanel.add(notesPanel, BorderLayout.CENTER);

        // 8. Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addBtn = new JButton("Add Record");
        JButton resetBtn = new JButton("Reset");
        addBtn.setBackground(new Color(46, 139, 87));
        addBtn.setForeground(Color.WHITE);
        
        btnPanel.add(addBtn);
        btnPanel.add(resetBtn);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Listeners
        uploadBtn.addActionListener(e -> chooseFile());
        addBtn.addActionListener(e -> handleAdd());
        resetBtn.addActionListener(e -> resetForm());

        setVisible(true);
    }

    private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedInvoice = chooser.getSelectedFile();
            filePathLabel.setText(selectedInvoice.getName());
        }
    }

    private void handleAdd() {
        // Simple Validation
        if (nameField.getText().isEmpty() || priceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill required fields!");
            return;
        }

        saveToDatabase();
    }

    private void saveToDatabase() {
        String sql = "INSERT INTO items(name, supplier, type, quantity, price, is_damaged, notes, purchase_date) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nameField.getText());
            ps.setString(2, supplierField.getText());
            ps.setString(3, typeCombo.getSelectedItem().toString());
            ps.setInt(4, (int) quantitySpinner.getValue());
            ps.setDouble(5, Double.parseDouble(priceField.getText()));
            ps.setBoolean(6, damagedCheck.isSelected());
            ps.setString(7, notesArea.getText());
            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis())); // Current Date

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Material Added Successfully!");
            resetForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void resetForm() {
        nameField.setText("");
        supplierField.setText("");
        priceField.setText("");
        notesArea.setText("");
        typeCombo.setSelectedIndex(0);
        quantitySpinner.setValue(1);
        damagedCheck.setSelected(false);
        filePathLabel.setText("No file selected");
        selectedInvoice = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inventory_Add::new);
    }
}