/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttontest;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alice bain
 */

public class ButtonTest extends JFrame implements ActionListener {  
    private JLabel countLabel;
    private JButton button;  private int count = 0;
    private Container contentPane;  public ButtonTest() {
    contentPane = getContentPane();  contentPane.setLayout(new GridLayout(2,1));
    // change the count to string. alignment is center
     countLabel = new JLabel(Integer.toString(count), JLabel.CENTER);  button = new JButton("Click me");
     contentPane.add(countLabel);
    contentPane.add(button);
// the class is an action listener  button.addActionListener(this);
}	// end ButtonTest

// what happens after you click the button
public void actionPerformed(ActionEvent e) {  
    count++;  countLabel.setText(Integer.toString(count));
}   // end actionPerfomed

public static void main(String[] args) {  
    ButtonTest f = new ButtonTest();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  f.pack();
    f.setVisible(true);
}	// end main
}

