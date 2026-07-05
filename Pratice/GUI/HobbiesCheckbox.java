import java.awt.*;
import javax.swing.*;

public class HobbiesCheckbox extends JFrame {
    JCheckBox reading, sports, music;

    public HobbiesCheckbox() {
        setTitle("Hobbies");
        setSize(300, 220);
        setLayout(new GridLayout(5, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reading = new JCheckBox("Reading");
        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");

        JButton showBtn = new JButton("Show Hobbies");

        add(reading);
        add(sports);
        add(music);
        add(showBtn);

        showBtn.addActionListener(e -> {
            StringBuilder hobbies = new StringBuilder();
            if (reading.isSelected()) hobbies.append("Reading ");
            if (sports.isSelected()) hobbies.append("Sports ");
            if (music.isSelected()) hobbies.append("Music ");

            if (hobbies.length() == 0) {
                JOptionPane.showMessageDialog(this, "No hobby selected");
            } else {
                JOptionPane.showMessageDialog(this, "Selected: " + hobbies.toString().trim());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new HobbiesCheckbox();
    }
}