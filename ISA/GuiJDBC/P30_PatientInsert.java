import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 30. Insert hospital patient details
public class P30_PatientInsert extends JFrame {
    JTextField idField, nameField, diseaseField;

    public P30_PatientInsert() {
        setTitle("Patient Details");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idField = new JTextField();
        nameField = new JTextField();
        diseaseField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Patient ID")); add(idField);
        add(new JLabel("Name")); add(nameField);
        add(new JLabel("Disease")); add(diseaseField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patients(id, name, disease) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, diseaseField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Patient saved");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P30_PatientInsert(); }
}
