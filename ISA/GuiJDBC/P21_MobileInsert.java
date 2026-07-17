import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 21. Insert mobile phone details
public class P21_MobileInsert extends JFrame {
    JTextField brandField, modelField, priceField;

    public P21_MobileInsert() {
        setTitle("Insert Mobile");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        brandField = new JTextField();
        modelField = new JTextField();
        priceField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Brand")); add(brandField);
        add(new JLabel("Model")); add(modelField);
        add(new JLabel("Price")); add(priceField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO mobiles(brand, model, price) VALUES (?,?,?)");
            ps.setString(1, brandField.getText());
            ps.setString(2, modelField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Mobile inserted");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P21_MobileInsert(); }
}
