import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonMessage2 extends javax.swing.JFrame {
    public ButtonMessage2() {
        setTitle("Button Message");
        setSize(300,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Click Me");
        btn.addActionListener( e -> JOptionPane.showMessageDialog(this,"Hello there "));

        add(btn);
        setVisible(true);


    }
    public static void main(String[] args) {
        new ButtonMessage2();
    }
    
}
