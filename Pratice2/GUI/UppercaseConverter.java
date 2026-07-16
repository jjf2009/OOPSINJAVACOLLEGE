
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class UppercaseConverter extends JFrame {
    JTextField input, output;

    public UppercaseConverter() {
        setTitle("Hello");
        setSize(350,180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,10,10));

        input = new JTextField();
        output = new JTextField();
        add(new Label("Input"));
        add(input);
        add(new Label("Output"));
        add(output);
        
        JButton btn = new JButton("Convert");
        add(new Label(" "));
        add(btn);

        btn.addActionListener( e -> output.setText(input.getText().toUpperCase()));
    
        setVisible(true);
    }

     
    public static void main(String[] args){
        new UppercaseConverter();
    }
    
}
