import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Student {
    String roll, name;
    int[] marks;

    Student(String r, String n, int[] m) {
        roll = r;
        name = n;
        marks = m;
    }
}

class StudentView extends JFrame {
    JTable table;
    JTextField searchField;
    JLabel nameLabel, imageLabel;
    JLabel[] subjectLabels;
    JButton exportBtn;
    DefaultTableModel model;

    StudentView() {
        setTitle("Student Marks Dashboard");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSplitPane splitPane = new JSplitPane();

        // Left Panel
        JPanel leftPanel = new JPanel(new BorderLayout());

        searchField = new JTextField();
        searchField.setBorder(new TitledBorder("Search"));

        String[] cols = {"Roll", "Name", "Sub1", "Sub2", "Sub3", "Sub4", "Sub5"};

        Object[][] data = {
                {"101", "John", 90, 85, 88, 92, 95},
                {"102", "Alice", 70, 75, 78, 80, 82},
                {"103", "Bob", 95, 90, 93, 96, 98}
        };

        model = new DefaultTableModel(data, cols);

        table = new JTable(model) {
            public Component prepareRenderer(TableCellRenderer r, int row, int col) {
                Component c = super.prepareRenderer(r, row, col);
                if (row % 2 == 0)
                    c.setBackground(new Color(230, 240, 255));
                else
                    c.setBackground(Color.WHITE);
                return c;
            }
        };

        JScrollPane scroll = new JScrollPane(table);

        leftPanel.add(searchField, BorderLayout.NORTH);
        leftPanel.add(scroll, BorderLayout.CENTER);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(20,20,20,20));

        nameLabel = new JLabel("Select Student");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));

        imageLabel = new JLabel(new ImageIcon("grade.png"));

        subjectLabels = new JLabel[5];
        for(int i=0;i<5;i++) {
            subjectLabels[i] = new JLabel("Subject " + (i+1));
            subjectLabels[i].setBorder(new LineBorder(Color.GRAY));
            subjectLabels[i].setPreferredSize(new Dimension(200,30));
            rightPanel.add(subjectLabels[i]);
        }

        exportBtn = new JButton("Export");
        exportBtn.setToolTipText("Export Student Data");
        exportBtn.setMnemonic(KeyEvent.VK_E);

        rightPanel.add(nameLabel);
        rightPanel.add(imageLabel);
        rightPanel.add(exportBtn);

        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        add(splitPane);
        setVisible(true);
    }
}

class StudentController {
    StudentView view;
    TableRowSorter<DefaultTableModel> sorter;

    StudentController(StudentView v) {
        view = v;

        sorter = new TableRowSorter<>(view.model);
        view.table.setRowSorter(sorter);

        view.searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }

            void filter() {
                sorter.setRowFilter(RowFilter.regexFilter(view.searchField.getText()));
            }
        });

        view.table.getSelectionModel().addListSelectionListener(e -> {
            int row = view.table.getSelectedRow();

            if(row >= 0) {
                row = view.table.convertRowIndexToModel(row);

                view.nameLabel.setText(view.model.getValueAt(row,1).toString());

                for(int i=0;i<5;i++) {
                    view.subjectLabels[i].setText(
                            "Subject " + (i+1) + " : " +
                            view.model.getValueAt(row,i+2)
                    );
                }
            }
        });

        view.exportBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(view,
                    "Export Successful!");
        });
    }
}

public class StudentDashboard {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {}

        StudentView view = new StudentView();
        new StudentController(view);
    }
}