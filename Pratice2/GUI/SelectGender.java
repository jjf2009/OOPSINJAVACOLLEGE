
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SelectGender extends JFrame {
     JRadioButton male,female;

    public SelectGender()  {
        setTitle("Hello");
        setSize(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1,10,10));
        
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup  gr = new ButtonGroup();
        gr.add(male);
        gr.add(female);

    
        JButton show = new JButton("Show");
        add(male);
        add(female);
        add(show);
        show.addActionListener( e -> {
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Not Selected";
            JOptionPane.showMessageDialog(this, "Selected Gender:" + gender);
        });

       setVisible(true);
    }
          

    public static void main(String[] args) {
        new SelectGender();
    }
}
