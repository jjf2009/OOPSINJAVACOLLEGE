import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;


// ---------------- MODEL ----------------
class StudentModel {

    String[] columns = {
            "Roll No", "Name",
            "Sub1", "Sub2", "Sub3", "Sub4", "Sub5"
    };

    Object[][] data = {
            {"101", "John", 90, 85, 88, 92, 95},
            {"102", "Alice", 70, 75, 78, 80, 82},
            {"103", "Bob", 95, 90, 93, 96, 98},
            {"104", "David", 60, 65, 70, 68, 72}
    };
}


// ---------------- VIEW ----------------
class StudentView extends JFrame {

    JTable table;
    JTextField searchField;
    JLabel nameLabel, imageLabel;
    JLabel[] subjectLabels;
    JButton exportBtn;
    DefaultTableModel tableModel;

    StudentView(StudentModel model) {

        setTitle("Student Marks Dashboard");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Split Pane
        JSplitPane splitPane = new JSplitPane();

        // ---------------- LEFT PANEL ----------------
        JPanel leftPanel = new JPanel(new BorderLayout());

        // Search Field
        searchField = new JTextField();
        searchField.setBorder(new TitledBorder("Search Student"));

        // Table
        tableModel = new DefaultTableModel(model.data, model.columns);

        table = new JTable(tableModel) {

            // Alternate row colors
            public Component prepareRenderer(
                    TableCellRenderer renderer,
                    int row,
                    int column) {

                Component c =
                        super.prepareRenderer(renderer, row, column);

                if (!isRowSelected(row)) {

                    if (row % 2 == 0)
                        c.setBackground(new Color(220, 235, 255));

                    else
                        c.setBackground(Color.WHITE);
                }

                return c;
            }
        };

        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);

        leftPanel.add(searchField, BorderLayout.NORTH);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        // ---------------- RIGHT PANEL ----------------
        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(
                new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.setBorder(
                new EmptyBorder(20, 20, 20, 20));

        // Student Name
        nameLabel = new JLabel("Select Student");
        nameLabel.setFont(
                new Font("Arial", Font.BOLD, 24));

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Grade Image
        imageLabel = new JLabel(
                new ImageIcon("grade.png"));

        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subject Labels
        subjectLabels = new JLabel[5];

        for (int i = 0; i < 5; i++) {

            subjectLabels[i] =
                    new JLabel("Subject " + (i + 1));

            subjectLabels[i].setFont(
                    new Font("Arial", Font.PLAIN, 16));

            subjectLabels[i].setBorder(
                    new LineBorder(Color.GRAY));

            subjectLabels[i].setPreferredSize(
                    new Dimension(200, 35));

            subjectLabels[i].setMaximumSize(
                    new Dimension(250, 35));

            rightPanel.add(Box.createVerticalStrut(10));
            rightPanel.add(subjectLabels[i]);
        }

        // Export Button
        exportBtn = new JButton("Export");

        exportBtn.setToolTipText("Export Student Data");

        exportBtn.setMnemonic(KeyEvent.VK_E);

        exportBtn.setBackground(new Color(70, 130, 180));

        exportBtn.setForeground(Color.WHITE);

        exportBtn.setFocusPainted(false);

        exportBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add Components
        rightPanel.add(nameLabel);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(imageLabel);
        rightPanel.add(Box.createVerticalStrut(20));

        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(exportBtn);

        // Add Panels to SplitPane
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        splitPane.setDividerLocation(500);

        add(splitPane);

        setVisible(true);
    }
}


// ---------------- CONTROLLER ----------------
class StudentController {

    StudentView view;

    TableRowSorter<DefaultTableModel> sorter;

    StudentController(StudentView view) {

        this.view = view;

        // Table Filtering
        sorter =
                new TableRowSorter<>(view.tableModel);

        view.table.setRowSorter(sorter);

        // Real-time Search
        view.searchField.getDocument()
                .addDocumentListener(new DocumentListener() {

                    public void insertUpdate(DocumentEvent e) {
                        filter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        filter();
                    }

                    public void changedUpdate(DocumentEvent e) {
                        filter();
                    }

                    private void filter() {

                        String text =
                                view.searchField.getText();

                        if (text.trim().length() == 0) {

                            sorter.setRowFilter(null);

                        } else {

                            sorter.setRowFilter(
                                    RowFilter.regexFilter(
                                            "(?i)" + Pattern.quote(text)
                                    )
                            );
                        }
                    }
                });

        // Row Selection
view.table.getSelectionModel()
        .addListSelectionListener(e -> {

            int row = view.table.getSelectedRow();

            if (row >= 0) {

                int modelRow =
                        view.table.convertRowIndexToModel(row);

                // Student Name
                view.nameLabel.setText(
                        view.tableModel.getValueAt(modelRow, 1)
                                .toString());

                int total = 0;

                // Subject Marks
                for (int i = 0; i < 5; i++) {

                    int mark = Integer.parseInt(
                            view.tableModel.getValueAt(
                                    modelRow,
                                    i + 2).toString());

                    total += mark;

                    view.subjectLabels[i].setText(
                            "Subject " + (i + 1)
                                    + " : " + mark);
                }

                // Calculate Average
                int avg = total / 5;

                String gradeImage;

                // Grade Logic
                if (avg >= 90)
                    gradeImage = "A.png";

                else if (avg >= 75)
                    gradeImage = "B.png";

                else if (avg >= 60)
                    gradeImage = "C.png";

                else if (avg >= 40)
                    gradeImage = "D.png";

                else
                    gradeImage = "F.png";

                // Update Image
                view.imageLabel.setIcon(
                        new ImageIcon(gradeImage));
            }
        });

        // Export Button
        view.exportBtn.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    view,
                    "Student Data Exported Successfully!"
            );
        });
    }
}


// ---------------- MAIN ----------------
public class StudentDashboard {

    public static void main(String[] args) {

        // Nimbus Look and Feel
        try {

            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // MVC Objects
        StudentModel model = new StudentModel();

        StudentView view = new StudentView(model);

        new StudentController(view);
    }
}