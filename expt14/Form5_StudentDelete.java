import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Form5_StudentDelete extends JFrame {

    JTable table;
    DefaultTableModel model;
    JLabel status;

    public Form5_StudentDelete() {

        setTitle("Delete Student");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();

        model.setColumnIdentifiers(
                new String[]{
                        "ID","Name","Email","Course"
                });

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        JPanel top = new JPanel();

        top.add(deleteBtn);
        top.add(refreshBtn);

        status = new JLabel();

        add(top, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        deleteBtn.addActionListener(e -> deleteStudent());

        refreshBtn.addActionListener(e -> loadData());

        loadData();

        setVisible(true);
    }

    void loadData() {

        try {

            model.setRowCount(0);

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            int count = 0;

            while(rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                });

                count++;
            }

            status.setText("Total Records: " + count);

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    void deleteStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Select a row first");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete selected student?"
        );

        if(confirm == JOptionPane.YES_OPTION) {

            try {

                int id =
                        (int) model.getValueAt(row,0);

                Connection con =
                        DBConnection.getConnection();

                String sql =
                        "DELETE FROM students WHERE id=?";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setInt(1, id);

                ps.executeUpdate();

                model.removeRow(row);

                status.setText(
                        "Total Records: " +
                                model.getRowCount()
                );

                JOptionPane.showMessageDialog(this,
                        "Deleted Successfully");

                con.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Form5_StudentDelete();
    }
}