/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.*;

/**
 *
 * @author Alice bain
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              //Schedule a job for the event-dispatching thread:
     //creating and showing this application's GUI.

      javax.swing.SwingUtilities.invokeLater(new Runnable() {  
          public void run() {

              createAndShowGUI();

          }    // end run
      });

    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Exercise 7");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Mikaeli");
        frame.getContentPane().add(label);
 
        ImageIcon cat1 = createImageIcon("cat1.gif");

//Create the second label 
      
      JLabel label2 = new JLabel( 
                           "Label with text and icon", cat1,
                            JLabel.CENTER );

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,200);
    }    // end createAndShowGUI

    
}
