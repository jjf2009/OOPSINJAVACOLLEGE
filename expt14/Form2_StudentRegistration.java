import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Form2_StudentRegistration extends JFrame {

    JTextField nameField, emailField;
    JComboBox<String> courseBox, yearBox;
    JRadioButton male, female;
    JPasswordField pinField;
    JLabel idLabel;

    public Form2_StudentRegistration() {

        setTitle("Student Registration");
        setSize(500,400);
        setLayout(new GridLayout(9,2,10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameField = new JTextField();
        emailField = new JTextField();

        courseBox = new JComboBox<>(
                new String[]{"BCA","MCA","BTech"}
        );

        yearBox = new JComboBox<>(
                new String[]{"1","2","3","4"}
        );

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        pinField = new JPasswordField();

        JButton registerBtn = new JButton("Register");
        JButton resetBtn = new JButton("Reset");

        idLabel = new JLabel("Student ID: ");

        add(new JLabel("Name"));
        add(nameField);

        add(new JLabel("Email"));
        add(emailField);

        add(new JLabel("Course"));
        add(courseBox);

        add(new JLabel("Year"));
        add(yearBox);
        l;lpl[]

        add(new JLabel("Gender"));

        JPanel p = new JPanel();
        p.add(male);
        p.add(female);

        add(p);

        add(new JLabel("PIN"));
        add(pinField);

        add(registerBtn);
        add(resetBtn);

        add(idLabel);

        registerBtn.addActionListener(e -> registerStudent());
        resetBtn.addActionListener(e -> resetForm());

        setVisible(true);
    }

    void registerStudent() {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO students(name,email,course,year,gender,pin) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, nameField.getText());
            ps.setString(2, emailField.getText());
            ps.setString(3, courseBox.getSelectedItem().toString());
            ps.setString(4, yearBox.getSelectedItem().toString());

            String gender =
                    male.isSelected() ? "Male" : "Female";

            ps.setString(5, gender);

            ps.setString(6,
                    new String(pinField.getPassword()));

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                idLabel.setText(
                        "Student ID: " + rs.getInt(1)
                );
            }

            JOptionPane.showMessageDialog(this,
                    "Inserted Successfully");

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    void resetForm() {

        nameField.setText("");
        emailField.setText("");
        pinField.setText("");
    }

    public static void main(String[] args) {
        new Form2_StudentRegistration();
    }
}