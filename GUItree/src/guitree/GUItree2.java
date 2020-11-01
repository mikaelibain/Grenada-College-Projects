package guitree;

import javax.swing.*; // Need this to reach Swing components
import java.awt.*; // Need this to reach FlowLayout
public class GUItree2 extends JFrame {  
    
    public GUItree2(){
    super("GUI Tree Flowed Example");
    this.getContentPane().setLayout(new FlowLayout());
/* Put in a panel with a label in it */  
JPanel panel1 = new JPanel();  
this.getContentPane().add(panel1);
JLabel label = new JLabel("This is panel 1!");  
panel1.add(label);
/* Put in another panel with two buttons in it */  
JPanel panel2 = new JPanel();  
this.getContentPane().add(panel2);
JButton button1 = new JButton("Make a sound");  
panel2.add(button1);
JButton button2 = new JButton("Make a picture");  
panel2.add(button2);
this.pack();  
this.setVisible(true);
}
}
