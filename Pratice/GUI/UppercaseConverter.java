import java.awt.*;
import javax.swing.*;

public class UppercaseConverter extends JFrame {
    JTextField inputField, outputField;

    public UppercaseConverter() {
        setTitle("Uppercase Converter");
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        outputField = new JTextField();
        outputField.setEditable(false);

        JButton convertBtn = new JButton("Convert");

        add(new JLabel("Enter Text"));
        add(inputField);
        add(convertBtn);
        add(outputField);

        convertBtn.addActionListener(e ->
                outputField.setText(inputField.getText().toUpperCase()));

        setVisible(true);
    }

    public static void main(String[] args) {
        new UppercaseConverter();
    }
}