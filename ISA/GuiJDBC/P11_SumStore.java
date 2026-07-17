import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 11. Calculate sum of two numbers and store in database
public class P11_SumStore extends JFrame {
    JTextField n1Field, n2Field;

    public P11_SumStore() {
        setTitle("Sum & Store");
        setSize(350, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        n1Field = new JTextField();
        n2Field = new JTextField();
        JButton btn = new JButton("Calculate & Save");

        add(new JLabel("Number 1")); add(n1Field);
        add(new JLabel("Number 2")); add(n2Field);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> save());
        setVisible(true);
    }

    void save() {
        try {
            double a = Double.parseDouble(n1Field.getText());
            double b = Double.parseDouble(n2Field.getText());
            double sum = a + b;
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO calculations(num1, num2, sum_result) VALUES (?,?,?)");
            ps.setDouble(1, a);
            ps.setDouble(2, b);
            ps.setDouble(3, sum);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Sum = " + sum + " saved to DB");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P11_SumStore(); }
}
