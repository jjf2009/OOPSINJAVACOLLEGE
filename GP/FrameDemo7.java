// Button which displays an image when clicked
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class ButtonDemo1 extends JFrame implements ActionListener {
    JButton b;
    JLabel lbl;

    ButtonDemo1() {
        // Create container
        Container c = getContentPane();
        // Set a layout for the container
        c.setLayout(new FlowLayout());

        // Store the image into ImageIcon object
        ImageIcon ii = new ImageIcon("logo.png");

        // Create the button with the image
        b = new JButton("Click Me", ii);

        // Set background and foreground colors for the button
        b.setBackground(Color.yellow);
        b.setForeground(Color.red);

        // Set font for the label of the button
        b.setFont(new Font("Arial", Font.BOLD, 30));

        // Set bevel border for the button
        Border bd = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        b.setBorder(bd);

        // Set tool tip text for the button
        b.setToolTipText("This is a button");

        // Set a shortcut key for the button. Alt+C will invoke the button
        b.setMnemonic('C');

        // Add the button to the container
        c.add(b);

        // Add action listener to the button
        b.addActionListener(this);

        // Create an empty label and add it to the content pane
        lbl = new JLabel();
        c.add(lbl);

        // Close the frame upon clicking
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        // Set some image to the label. This image is displayed when the button is clicked
        ImageIcon ii = new ImageIcon("logo.png");
        lbl.setIcon(ii);
    }

    public static void main(String args[]) {
        // Create a frame
        ButtonDemo1 obj = new ButtonDemo1();
        obj.setTitle("My Button");
        obj.setSize(500, 400);
        obj.setVisible(true);
    }
}