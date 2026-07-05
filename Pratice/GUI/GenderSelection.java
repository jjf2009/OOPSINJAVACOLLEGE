import java.awt.*;
import javax.swing.*;

public class GenderSelection extends JFrame {
    JRadioButton male, female;

    public GenderSelection() {
        setTitle("Gender Selection");
        setSize(300, 180);
        setLayout(new GridLayout(3, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JButton showBtn = new JButton("Show Selection");

        add(male);
        add(female);
        add(showBtn);

        showBtn.addActionListener(e -> {
            String gender = male.isSelected() ? "Male"
                    : female.isSelected() ? "Female" : "Not selected";
            JOptionPane.showMessageDialog(this, "Selected Gender: " + gender);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GenderSelection();
    }
}