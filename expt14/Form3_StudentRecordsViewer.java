import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Form3_StudentRecordsViewer extends JFrame {

    JTable table;
    DefaultTableModel model;
    JLabel status;

    public Form3_StudentRecordsViewer() {

        setTitle("Student Records");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();

        model.setColumnIdentifiers(
                new String[]{
                        "ID","Name","Email",
                        "Course","Year","Gender"
                });

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        JButton refreshBtn = new JButton("Refresh");

        status = new JLabel();

        add(sp, BorderLayout.CENTER);
        add(refreshBtn, BorderLayout.NORTH);
        add(status, BorderLayout.SOUTH);

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
                        rs.getString("course"),
                        rs.getString("year"),
                        rs.getString("gender")
                });

                count++;
            }

            status.setText("Total Records: " + count);

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Form3_StudentRecordsViewer();
    }
}