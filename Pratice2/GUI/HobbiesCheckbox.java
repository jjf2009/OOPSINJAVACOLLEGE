import java.awt.*;
import javax.swing.*;

public class HobbiesCheckbox extends JFrame {
    JCheckBox ch1 , ch2;

    public HobbiesCheckbox()  {
        setTitle("Hello");
        setSize(300,300);
        setLayout(new GridLayout(5, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

        ch1 = new JCheckBox("Running");
        ch2 = new JCheckBox("Paiting ");

        JButton btn = new JButton("Submit");
        add(ch1);
        add(ch2);
        add(btn);

        btn.addActionListener( e -> {
            StringBuilder string = new StringBuilder();
            if(ch1.isSelected()) string.append("Running,");
            if(ch2.isSelected()) string.append("Paiting,");
            if(string.length()==0){
                JOptionPane.showMessageDialog(this, "Nothing is Selected");
            }else {
                 JOptionPane.showMessageDialog(this, string.toString().trim());
            }
        });

        setVisible(true);

        
    }


    
 public static void main(String[] args) {
     new HobbiesCheckbox();
 }
}
