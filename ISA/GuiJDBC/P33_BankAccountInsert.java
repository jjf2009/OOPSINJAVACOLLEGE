import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 33. Insert bank account details
public class P33_BankAccountInsert extends JFrame {
    JTextField accField, nameField, balField;

    public P33_BankAccountInsert() {
        setTitle("Bank Account");
        setSize(400, 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        accField = new JTextField();
        nameField = new JTextField();
        balField = new JTextField();
        JButton btn = new JButton("Insert");

        add(new JLabel("Account No")); add(accField);
        add(new JLabel("Holder Name")); add(nameField);
        add(new JLabel("Balance")); add(balField);
        add(new JLabel("")); add(btn);

        btn.addActionListener(e -> insert());
        setVisible(true);
    }

    void insert() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO accounts(acc_no, holder_name, balance) VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(accField.getText()));
            ps.setString(2, nameField.getText());
            ps.setDouble(3, Double.parseDouble(balField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Account created");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P33_BankAccountInsert(); }
}
