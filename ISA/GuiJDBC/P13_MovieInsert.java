import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 13. Insert movie details using JDBC
public class P13_MovieInsert extends JFrame {
    JTextField idField, titleField, yearField;

    public P13_MovieInsert() {
        setTitle("Insert Movie");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        titleField = new JTextField();
        yearField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Movie ID")); add(idField);
        add(new JLabel("Title")); add(titleField);
        add(new JLabel("Year")); add(yearField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO movies(id, title, year) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, titleField.getText());
            ps.setInt(3, Integer.parseInt(yearField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Movie inserted");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P13_MovieInsert(); }
}
