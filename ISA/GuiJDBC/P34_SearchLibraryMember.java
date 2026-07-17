import java.awt.*;
import java.sql.*;
import javax.swing.*;

// 34. Search library member by Member ID
public class P34_SearchLibraryMember extends JFrame {
    JTextField idField;
    JTextArea result;

    public P34_SearchLibraryMember() {
        setTitle("Search Member");
        setSize(400, 220);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(1, 3, 5, 5));
        idField = new JTextField();
        JButton btn = new JButton("Search");
        top.add(new JLabel("Member ID"));
        top.add(idField);
        top.add(btn);

        result = new JTextArea();
        result.setEditable(false);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(result), BorderLayout.CENTER);

        btn.addActionListener(e -> search());
        setVisible(true);
    }

    void search() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM library_members WHERE id=?");
            ps.setInt(1, Integer.parseInt(idField.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result.setText("ID: " + rs.getInt("id")
                    + "\nName: " + rs.getString("name")
                    + "\nPhone: " + rs.getString("phone"));
            else
                result.setText("Member not found");
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) { new P34_SearchLibraryMember(); }
}
