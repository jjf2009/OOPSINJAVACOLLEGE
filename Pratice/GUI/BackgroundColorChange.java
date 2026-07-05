import java.awt.*;
import javax.swing.*;

public class BackgroundColorChange extends JFrame {
    JPanel panel;

    public BackgroundColorChange() {
        setTitle("Background Color");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton redBtn = new JButton("Red");
        JButton greenBtn = new JButton("Green");
        JButton blueBtn = new JButton("Blue");

        redBtn.addActionListener(e -> panel.setBackground(Color.RED));
        greenBtn.addActionListener(e -> panel.setBackground(Color.GREEN));
        blueBtn.addActionListener(e -> panel.setBackground(Color.BLUE));

        btnPanel.add(redBtn);
        btnPanel.add(greenBtn);
        btnPanel.add(blueBtn);

        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BackgroundColorChange();
    }
}