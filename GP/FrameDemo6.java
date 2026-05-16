// A Java program to create a button with an image, colors, border, tooltip text, and shortcut key.
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class ButtonDemo extends JFrame {
    JButton b;

    ButtonDemo() {
        // Create the container
        Container c = getContentPane();
        
        // Set a layout for the container
        c.setLayout(new FlowLayout());

        // Store the image into an ImageIcon object
        ImageIcon ii = new ImageIcon("logo.png");

        // Create the button with an image and label text
        b = new JButton("Click Me", ii);

        // Set background and foreground colors for the button
        b.setBackground(Color.yellow);
        b.setForeground(Color.red);

        // Set font for the label of the button
        b.setFont(new Font("Arial", Font.BOLD, 30));

        // Set a bevel border for the button
        Border bd = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        b.setBorder(bd);

        // Set tool tip text for the button
        b.setToolTipText("This is a button");

        // Set a shortcut key for the button. Alt+C from keyboard will invoke the button
        b.setMnemonic('C');

        // Add the button to the container
        c.add(b);

        // Close the frame upon clicking
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create a frame
        ButtonDemo obj = new ButtonDemo();
        obj.setTitle("My Button");
        obj.setSize(500, 400);
        obj.setVisible(true);
    }
}