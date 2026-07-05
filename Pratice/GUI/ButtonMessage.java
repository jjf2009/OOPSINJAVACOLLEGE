import java.awt.*;
import javax.swing.*;

public class ButtonMessage extends JFrame {
    public ButtonMessage() {
        setTitle("Button Message");
        setSize(300, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Click Me");
        btn.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Hello! Button clicked."));

        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonMessage();
    }
}