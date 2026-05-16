import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class BorderDemo extends JFrame {
    // Variables
    JButton b1, b2, b3, b4, b5, b6, b7, b8;

    BorderDemo() {
        // Create content pane c
        Container c = getContentPane();
        
        // Set a layout for content pane
        c.setLayout(new FlowLayout());
        
        // Create push buttons
        b1 = new JButton("Raised Bevel Border");
        b2 = new JButton("Lowered Bevel Border");
        b3 = new JButton("Raised Etched Border");
        b4 = new JButton("Lowered Etched Border");
        b5 = new JButton("Line Border");
        b6 = new JButton("Matte Border");
        b7 = new JButton("Compound Border");
        b8 = new JButton("Empty Border");

        // Set raised bevel border for b1 with high light color: red and shadow color: green
        Border bd = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green);
        b1.setBorder(bd);

        // Set lowered bevel border for b2 with its current background color for highlight and shadow
        bd = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        b2.setBorder(bd);

        // Set raised etched border for b3 with high light color: red and shadow color: green
        bd = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.red, Color.green);
        b3.setBorder(bd);

        // Set lowered etched border for b4 with its current background color for highlight and shadow
        bd = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        b4.setBorder(bd);

        // Set line border for b5 with red color and width 5 px
        bd = BorderFactory.createLineBorder(Color.red, 5);
        b5.setBorder(bd);

        // Set matte border for b6 with top, left, bottom, right widths as 5,10,15,20 px and in red color
        bd = BorderFactory.createMatteBorder(5, 10, 15, 20, Color.red);
        b6.setBorder(bd);

        // Set compound border for b7 without any borders inside or outside edges
        bd = BorderFactory.createCompoundBorder();
        b7.setBorder(bd);

        // Set empty border for b8 without any space for border
        bd = BorderFactory.createEmptyBorder();
        b8.setBorder(bd);

        // Add the buttons to the container
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        c.add(b7);
        c.add(b8);

        // Close the frame upon clicking
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        // Create a frame
        BorderDemo obj = new BorderDemo();
        
        // Set the title and size for frame
        obj.setTitle("Borders");
        obj.setSize(500, 400);
        
        // Display the frame
        obj.setVisible(true);
    }
}