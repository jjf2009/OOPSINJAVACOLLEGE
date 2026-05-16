import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel {
    MyPanel() {
        this.setBackground(Color.green);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica", Font.BOLD, 34));
        g.drawString("Hello Learners!", 50, 100);
    }
}

class FrameDemo3 extends JFrame {
    FrameDemo3() {
        // Create content pane
        Container c = this.getContentPane();
        
        // Create MyPanel object and add it to c
        MyPanel mp = new MyPanel();
        c.add(mp);
    }

    public static void main(String[] args) {
        // Create the frame
        FrameDemo3 obj = new FrameDemo3();
        
        // Set a title for the frame
        obj.setTitle("My swing frame");
        
        // Set the size to 300 by 300 pixels
        obj.setSize(400, 400);
        
        // Display the frame
        obj.setVisible(true);
        
        // Close the application upon clicking on close button of frame
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}