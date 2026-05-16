import javax.swing.*;
import java.awt.*;

class FrameDemo extends JFrame {
    // Variables
    JLabel lbl;

    FrameDemo() {
        // Create content pane
        Container c = this.getContentPane();
        // Set the layout manager to content pane
        c.setLayout(new FlowLayout());
        // Set background color for content pane
        c.setBackground(Color.GREEN);

        // Create a label with some text
        lbl = new JLabel("Hello Learners!");
        // Set font for label
        lbl.setFont(new Font("Helvetica", Font.BOLD, 34));
        // Set red color for label
        lbl.setForeground(Color.RED);
        // Add the label to content pane
        c.add(lbl);
    }

    public static void main(String[] args) {
        // Create the frame
        FrameDemo obj = new FrameDemo();
        // Set a title for the frame
        obj.setTitle("My Swing Frame");
        // Set the size to 300 by 300 pixels
        obj.setSize(300, 300);
        // Display the frame
        obj.setVisible(true);
        // Close the application upon clicking on close button of frame
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}