
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

class LookFeel extends JFrame implements ItemListener {
    // Variables
    JButton b;
    JCheckBox cb;
    JTextField t;
    JRadioButton r1, r2, r3;
    ButtonGroup bg;
    Container c;

    LookFeel() {
        // Create content pane
        c = this.getContentPane();
        // Set flow layout to c
        c.setLayout(null);

        // Create components
        b = new JButton("Button");
        cb = new JCheckBox("CheckBox");
        t = new JTextField("TextField", 15);
        r1 = new JRadioButton("Metal");
        r2 = new JRadioButton("Motif");
        r3 = new JRadioButton("Windows");

        // Create ButtonGroup object and add radio buttons to specify
        // that they belong to the same group
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        // Set the location of components in content pane
        b.setBounds(100, 50, 75, 40);
        cb.setBounds(100, 100, 100, 40);
        t.setBounds(100, 150, 100, 40);
        r1.setBounds(50, 250, 100, 30);
        r2.setBounds(150, 250, 100, 30);
        r3.setBounds(250, 250, 100, 30);

        // Add the components to content pane
        c.add(b);
        c.add(cb);
        c.add(t);
        c.add(r1);
        c.add(r2);
        c.add(r3);

        // Add item listeners to radio buttons
        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);

        // Close the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            // Know which radio button is selected and accordingly change
            // the look and feel
            if (r1.getModel().isSelected()) {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            }
            if (r2.getModel().isSelected()) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            }
            if (r3.getModel().isSelected()) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }

            // Change the look and feel in the content pane
            SwingUtilities.updateComponentTreeUI(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // Create the frame
        LookFeel lf = new LookFeel();
        lf.setSize(400, 400);
        lf.setTitle("Look and Feel");
        lf.setVisible(true);
    }
}