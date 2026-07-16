
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class CalculatorGUI extends JFrame {
    JTextField num1field;
    JTextField num2Field;
    JTextField resuTextField;

    public CalculatorGUI() {
        setTitle("Addition Calculator");
        setSize(350,180);
        setLayout(new GridLayout(4,2,10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        num1field = new JTextField();
        num2Field = new JTextField();
        resuTextField = new JTextField();

        JButton SButton = new JButton("Submit");

        add(new Label("Num 1"));
        add(num1field);
        add(new Label("Num 2"));
        add(num2Field);
        add(new Label("Result:"));
        add(resuTextField);
        add(new Label(" "));
        add(SButton);

        SButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1field.getText());
                int b = Integer.parseInt(num2Field.getText());
                resuTextField.setText(String.valueOf(a+b));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invaid Numbers");
            }
        });

        setVisible(true);
    }

    
    public static void main(String[] args) {
        new CalculatorGUI();
        
    }
    
}
