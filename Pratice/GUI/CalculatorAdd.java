import java.awt.*;
import javax.swing.*;

public class CalculatorAdd extends JFrame {
    JTextField num1Field, num2Field, resultField;

    public CalculatorAdd() {
        setTitle("Add Calculator");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton addBtn = new JButton("Add");

        add(new JLabel("Number 1"));
        add(num1Field);
        add(new JLabel("Number 2"));
        add(num2Field);
        add(addBtn);
        add(resultField);

        addBtn.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1Field.getText());
                int b = Integer.parseInt(num2Field.getText());
                resultField.setText(String.valueOf(a + b));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numbers");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorAdd();
    }
}