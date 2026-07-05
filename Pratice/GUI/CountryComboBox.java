import java.awt.*;
import javax.swing.*;

public class CountryComboBox extends JFrame {
    JComboBox<String> countryBox;

    public CountryComboBox() {
        setTitle("Country Selection");
        setSize(350, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        countryBox = new JComboBox<>(new String[]{
                "India", "USA", "UK", "Canada", "Australia"
        });

        JButton showBtn = new JButton("Show Country");

        showBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Selected Country: " + countryBox.getSelectedItem()));

        add(new JLabel("Select Country:"));
        add(countryBox);
        add(showBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryComboBox();
    }
}