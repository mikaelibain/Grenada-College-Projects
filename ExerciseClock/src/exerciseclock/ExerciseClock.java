/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseclock;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alice bain
 */
public class ExerciseClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Create JFrmae
         Clocks panel = new Clocks();  
 // create a new frame to hold the panel  
 JFrame clocked = new JFrame();  
// set the frame to exit when it is closed
clocked.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
clocked.add( panel ); // add the panel to the frame

clocked.setMinimumSize(new Dimension(800, 500));
clocked.setVisible( true ); // make the frame visible  

    
       
    }
    
}
