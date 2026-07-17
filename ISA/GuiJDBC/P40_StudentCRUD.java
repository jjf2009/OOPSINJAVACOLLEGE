import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 40. Full CRUD on student table: Insert, Update, Delete, Search
public class P40_StudentCRUD extends JFrame {
    JTextField rollField, nameField, courseField;
    JTextArea area;

    public P40_StudentCRUD() {
        setTitle("Student CRUD");
        setSize(500, 400);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        rollField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();
        form.add(new JLabel("Roll No")); form.add(rollField);
        form.add(new JLabel("Name")); form.add(nameField);
        form.add(new JLabel("Course")); form.add(courseField);

        JPanel buttons = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton insertBtn = new JButton("Insert");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton searchBtn = new JButton("Search");
        JButton viewBtn = new JButton("View All");
        buttons.add(insertBtn);
        buttons.add(updateBtn);
        buttons.add(deleteBtn);
        buttons.add(searchBtn);
        buttons.add(viewBtn);

        area = new JTextArea();
        area.setEditable(false);

        JPanel north = new JPanel(new BorderLayout());
        north.add(form, BorderLayout.CENTER);
        north.add(buttons, BorderLayout.SOUTH);

        add(north, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        insertBtn.addActionListener(e -> insert());
        updateBtn.addActionListener(e -> update());
        deleteBtn.addActionListener(e -> delete());
        searchBtn.addActionListener(e -> search());
        viewBtn.addActionListener(e -> viewAll());

        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(roll_no, name, course) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, courseField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Inserted");
            con.close();
            viewAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    void update() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, course=? WHERE roll_no=?");
            ps.setString(1, nameField.getText());
            ps.setString(2, courseField.getText());
            ps.setInt(3, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Updated" : "Not found");
            con.close();
            viewAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    void delete() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            int n = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, n > 0 ? "Deleted" : "Not found");
            con.close();
            viewAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    void search() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE roll_no=?");
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                courseField.setText(rs.getString("course"));
                area.setText("Found: " + rs.getInt("roll_no") + " | "
                    + rs.getString("name") + " | " + rs.getString("course"));
            } else {
                area.setText("Not found");
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    void viewAll() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("roll_no")).append(" | ")
                  .append(rs.getString("name")).append(" | ")
                  .append(rs.getString("course")).append("\n");
            }
            area.setText(sb.length() == 0 ? "No records" : sb.toString());
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P40_StudentCRUD(); }
}
