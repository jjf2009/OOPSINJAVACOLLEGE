import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EmployeeProfileViewer extends JFrame {

    JTable table;
    JLabel profileImage;
    JLabel nameLabel;
    JLabel roleLabel;

    JButton prevBtn;
    JButton nextBtn;

    int currentRow = 0;

    String[] columns = {
            "ID", "Name", "Role", "Department", "Photo"
    };

    Object[][] data = {
            {"101", "John", "Manager", "HR", "emp1.jpeg"},
            {"102", "Alice", "Developer", "IT", "emp2.jpeg"},
            {"103", "Bob", "Designer", "UI/UX", "emp3.png"}
    };

    public EmployeeProfileViewer() {

        // Frame
        setTitle("Employee Profile Viewer");

        setSize(1000, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // Windows Look and Feel
        try {

            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Layered Pane
        JLayeredPane layeredPane = new JLayeredPane();

        layeredPane.setPreferredSize(new Dimension(1000, 600));

        // ---------------- BOTTOM LAYER ----------------

        // Background Image
        JLabel background = new JLabel(
                new ImageIcon("background.jpg"));

        background.setBounds(0, 0, 1000, 600);

        background.setBorder(
                new LineBorder(Color.BLACK, 2));

        layeredPane.add(background, Integer.valueOf(0));

        // ---------------- MIDDLE LAYER ----------------

        // Glass Pane Style Transparent Panel
        JPanel glassPanel = new JPanel();

        glassPanel.setLayout(new BorderLayout());

        glassPanel.setBackground(
                new Color(255, 255, 255, 120));

        glassPanel.setOpaque(true);

        glassPanel.setBounds(30, 300, 500, 220);

        glassPanel.setBorder(
                new TitledBorder("Employee Records"));

        // JTable
        JTable table = new JTable(data, columns);

        table.setRowHeight(30);

        table.setBorder(new LineBorder(Color.GRAY));

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setPreferredSize(
                new Dimension(450, 180));

        glassPanel.add(scrollPane, BorderLayout.CENTER);

        layeredPane.add(glassPanel, Integer.valueOf(1));

        // ---------------- TOP LAYER ----------------

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(
                topPanel,
                BoxLayout.Y_AXIS));

        topPanel.setOpaque(false);

        topPanel.setBounds(650, 100, 250, 350);

        topPanel.setBorder(
                new EmptyBorder(10, 10, 10, 10));

        // Employee Image
        profileImage = new JLabel();

        profileImage.setPreferredSize(
                new Dimension(200, 200));

        profileImage.setBorder(
                new LineBorder(Color.WHITE, 3));

        profileImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Name Label
        nameLabel = new JLabel();

        nameLabel.setFont(
                new Font("Arial", Font.BOLD, 26));

        nameLabel.setForeground(Color.WHITE);

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Role Label
        roleLabel = new JLabel();

        roleLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        roleLabel.setForeground(Color.LIGHT_GRAY);

        roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Previous Button
        prevBtn = new JButton(
                "Previous",
                new ImageIcon("prev.png"));

        prevBtn.setMnemonic(KeyEvent.VK_P);

        prevBtn.setToolTipText("Previous Employee");

        prevBtn.setFocusPainted(false);

        prevBtn.setBorder(
                new LineBorder(Color.BLACK));

        prevBtn.setMaximumSize(
                new Dimension(180, 40));

        // Next Button
        nextBtn = new JButton(
                "Next",
                new ImageIcon("next.png"));

        nextBtn.setMnemonic(KeyEvent.VK_N);

        nextBtn.setToolTipText("Next Employee");

        nextBtn.setFocusPainted(false);

        nextBtn.setBorder(
                new LineBorder(Color.BLACK));

        nextBtn.setMaximumSize(
                new Dimension(180, 40));

        // Add Components
        topPanel.add(profileImage);

        topPanel.add(Box.createVerticalStrut(20));

        topPanel.add(nameLabel);

        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(roleLabel);

        topPanel.add(Box.createVerticalStrut(20));

        topPanel.add(prevBtn);

        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(nextBtn);

        layeredPane.add(topPanel, Integer.valueOf(2));

        // Add LayeredPane to Frame
        add(layeredPane);

        // Show First Employee
        updateProfile(0);

        // Table Selection
        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row = table.getSelectedRow();

                    if (row >= 0) {

                        currentRow = row;

                        updateProfile(row);
                    }
                });

        // Previous Button
        prevBtn.addActionListener(e -> {

            currentRow--;

            if (currentRow < 0)
                currentRow = data.length - 1;

            table.setRowSelectionInterval(
                    currentRow,
                    currentRow);

            updateProfile(currentRow);
        });

        // Next Button
        nextBtn.addActionListener(e -> {

            currentRow++;

            if (currentRow >= data.length)
                currentRow = 0;

            table.setRowSelectionInterval(
                    currentRow,
                    currentRow);

            updateProfile(currentRow);
        });

        setVisible(true);
    }

    // Update Employee Profile
    void updateProfile(int row) {

        nameLabel.setText(
                data[row][1].toString());

        roleLabel.setText(
                data[row][2].toString());

        ImageIcon icon =
                new ImageIcon(data[row][4].toString());

        Image img = icon.getImage().getScaledInstance(
                180,
                180,
                Image.SCALE_SMOOTH);

        profileImage.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {

        new EmployeeProfileViewer();
    }
}