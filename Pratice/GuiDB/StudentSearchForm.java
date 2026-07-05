import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StudentSearchForm extends JFrame {
    JTextField rollField;
    JTextArea resultArea;

    public StudentSearchForm() {
        setTitle("Search Student");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(2, 2, 10, 10));
        rollField = new JTextField();
        JButton searchBtn = new JButton("Search");

        top.add(new JLabel("Roll Number"));
        top.add(rollField);
        top.add(new JLabel(""));
        top.add(searchBtn);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        searchBtn.addActionListener(e -> searchStudent());
        setVisible(true);
    }

    void searchStudent() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM students WHERE roll_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(rollField.getText()));

            ResultSet rs = ps.executeQuery();
            resultArea.setText("");

            if (rs.next()) {
                resultArea.append("Roll No: " + rs.getInt("roll_no") + "\n");
                resultArea.append("Name: " + rs.getString("name") + "\n");
                resultArea.append("Course: " + rs.getString("course") + "\n");
            } else {
                resultArea.setText("Student not found.");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentSearchForm();
    }
}