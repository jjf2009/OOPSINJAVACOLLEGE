import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Form4_StudentUpdate extends JFrame {

    JTextField idField, nameField, emailField, courseField;

    JButton fetchBtn, updateBtn;

    public Form4_StudentUpdate() {

        setTitle("Student Update Form");

        setSize(500, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10,10));

        // =========================
        // TITLE
        // =========================

        JLabel title = new JLabel(
                "Update Student Details",
                JLabel.CENTER
        );

        title.setFont(new Font(
                "Arial",
                Font.BOLD,
                22
        ));

        add(title, BorderLayout.NORTH);

        // =========================
        // FORM PANEL
        // =========================

        JPanel formPanel = new JPanel();

        formPanel.setLayout(
                new GridLayout(4,2,10,10)
        );

        formPanel.setBorder(
                new EmptyBorder(20,20,20,20)
        );

        idField = new JTextField();

        nameField = new JTextField();

        emailField = new JTextField();

        courseField = new JTextField();

        formPanel.add(new JLabel("Student ID"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Course"));
        formPanel.add(courseField);

        add(formPanel, BorderLayout.CENTER);

        // =========================
        // BUTTON PANEL
        // =========================

        JPanel buttonPanel = new JPanel();

        fetchBtn = new JButton("Fetch");

        updateBtn = new JButton("Update");

        buttonPanel.add(fetchBtn);

        buttonPanel.add(updateBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // =========================
        // EVENTS
        // =========================

        fetchBtn.addActionListener(e -> fetchStudent());

        updateBtn.addActionListener(e -> updateStudent());

        setVisible(true);
    }

    // =====================================
    // FETCH STUDENT
    // =====================================

    void fetchStudent() {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    Integer.parseInt(idField.getText())
            );

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                nameField.setText(
                        rs.getString("name")
                );

                emailField.setText(
                        rs.getString("email")
                );

                courseField.setText(
                        rs.getString("course")
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Student Found"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Not Found"
                );
            }

            con.close();

        } catch(Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    // =====================================
    // UPDATE STUDENT
    // =====================================

    void updateStudent() {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, email=?, course=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(
                    1,
                    nameField.getText()
            );

            ps.setString(
                    2,
                    emailField.getText()
            );

            ps.setString(
                    3,
                    courseField.getText()
            );

            ps.setInt(
                    4,
                    Integer.parseInt(idField.getText())
            );

            int rows = ps.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Successful"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed"
                );
            }

            con.close();

        } catch(Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        new Form4_StudentUpdate();
    }
}