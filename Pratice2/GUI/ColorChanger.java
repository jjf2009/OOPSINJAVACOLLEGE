
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class ColorChanger extends JFrame{
    JPanel panel;

    public ColorChanger() {
        setTitle("Color Changer");
        setSize(350,180);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        add(panel,BorderLayout.CENTER);
        JPanel btnpanel = new JPanel();
        JButton  redbtn = new JButton("Red");
        JButton bluebtn = new JButton("Blue");
        JButton greenbtn = new JButton("Green");

        redbtn.addActionListener(e -> panel.setBackground(Color.RED));
        bluebtn.addActionListener(e -> panel.setBackground(Color.BLUE));
        greenbtn.addActionListener(e -> panel.setBackground(Color.GREEN));

        btnpanel.add(redbtn);
        btnpanel.add(bluebtn);
        btnpanel.add(greenbtn);

        add(btnpanel,BorderLayout.SOUTH);

        setVisible(true);

    }

    
    public static void main (String [] args){
          new ColorChanger();
    }
}