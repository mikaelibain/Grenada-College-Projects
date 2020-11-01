/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitree;
/**
 *
 * @author Alice bain
 */
import java.awt.FlowLayout;
import javax.swing.*;// A GUI that has various components in it, to demonstrate
// UI components and layout managers (rendering)  
public class GUItree extends JFrame {
public GUItree() {
// create the JFrame with the title  
super("GUI Tree Example");
this.getContentPane().setLayout(new FlowLayout());
// Put in a panel with a label in it  
JPanel panel1 = new JPanel();  
this.getContentPane().add(panel1);
JLabel label = new JLabel("This is panel 1!");  
panel1.add(label);
// Put in another panel with two buttons in it  
JPanel panel2 = new JPanel();  
this.getContentPane().add(panel2);
JButton button1 = new JButton("Make a sound");  
panel2.add(button1);
JButton button2 = new JButton("Make a picture");  
panel2.add(button2);

// set the size to fit the contents and show it  
this.pack();
this.setVisible(true);

// set the size to fit the contents and show it  this.pack();
this.setVisible(true);
}	// end GUItree
// test this class
public static void main(String[] args){  
    GUItree gt = new GUItree();
    gt.setSize(300,200);
}	// end main
}