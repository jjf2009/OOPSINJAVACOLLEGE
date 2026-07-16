import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentForm extends JFrame {
    JTextField namefield;
    JPasswordField rollfield;

    public StudentForm() {
        setTitle("Login Form");
        setSize(350, 180);
        setLayout(new GridLayout(3,2,10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        namefield = new JTextField();
        rollfield = new JPasswordField();
        JButton loginbtn = new JButton("Submit");

        add(new Label("Name"));
        add(namefield);
        add(new Label("Roll no"));
        add(rollfield);
        add(new Label(" "));
        add(loginbtn);

        loginbtn.addActionListener(e -> {
            String user = namefield.getText();
            String password = new String(rollfield.getPassword());
           
            JOptionPane.showMessageDialog(this, "Name of Student :" + user+"\n"+"Roll No:"+password);
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
    
}
