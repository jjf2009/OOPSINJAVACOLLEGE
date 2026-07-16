import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
    JTextField usernamefield;
    JPasswordField passwordfield;

    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 180);
        setLayout(new GridLayout(3,2,10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usernamefield = new JTextField();
        passwordfield = new JPasswordField();
        JButton loginbtn = new JButton("Login");

        add(new Label("Username"));
        add(usernamefield);
        add(new Label("Password"));
        add(passwordfield);
        add(new Label(" "));
        add(loginbtn);

        loginbtn.addActionListener(e -> {
            String user = usernamefield.getText();
            String password = new String(passwordfield.getPassword());
            if(user.equals("admin") && password.equals("123456")){
                JOptionPane.showMessageDialog(this, "Login Sucessfull");

            }else{
                JOptionPane.showMessageDialog(this, "Login UnSucessfull");
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
    
}
