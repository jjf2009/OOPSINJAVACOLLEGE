import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 18. Library member registration with DB connectivity
public class P18_LibraryMemberReg extends JFrame {
    JTextField idField, nameField, phoneField;

    public P18_LibraryMemberReg() {
        setTitle("Library Member Registration");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        nameField = new JTextField();
        phoneField = new JTextField();
        JButton btn = new JButton("Register");

        add(new JLabel("Member ID")); add(idField);
        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Phone")); add(phoneField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO library_members(id, name, phone) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, phoneField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Member registered");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P18_LibraryMemberReg(); }
}
