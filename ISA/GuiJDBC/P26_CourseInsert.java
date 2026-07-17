import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 26. Insert course details
public class P26_CourseInsert extends JFrame {
    JTextField codeField, nameField, creditsField;

    public P26_CourseInsert() {
        setTitle("Insert Course");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        codeField = new JTextField();
        nameField = new JTextField();
        creditsField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Code")); add(codeField);
        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Credits")); add(creditsField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO courses(code, name, credits) VALUES (?,?,?)");
            ps.setString(1, codeField.getText());
            ps.setString(2, nameField.getText());
            ps.setInt(3, Integer.parseInt(creditsField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Course inserted");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P26_CourseInsert(); }
}
