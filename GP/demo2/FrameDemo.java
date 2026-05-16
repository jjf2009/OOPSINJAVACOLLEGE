// /A simple frame with background color
import java.awt.*;
import javax.swing.*; //Container class
class FrameDemo extends JFrame
{
public static void main(String args[])
{
//create the frame
FrameDemo obj = new FrameDemo();
//create content pane. It is nothing but Container object c
Container c = obj.getContentPane();
//set green back ground color to c
c.setBackground(Color.green);
//set a title for the frame
obj.setTitle("My swing frame");

// /set the size to 200 by 200 px
obj.setSize(200,200);
//display the frame
obj.setVisible(true);
//close the application upon clicking on close button of frame
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}