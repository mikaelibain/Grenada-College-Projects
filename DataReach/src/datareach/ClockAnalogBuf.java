/*
 * Mikaeli Bain
 * 11/3/2017
 * Java Programming: Assignment1
 */
package datareach; 

import java.awt.*;
import javax.swing.*;

//create the class called ClockAnalogBuf
public final class ClockAnalogBuf extends JApplet {
    
    //create the clock componenet
    private final Clock _clock;                        // Our clock component.
    
    //create the main class
    public static void main(String[] args) {
                
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Mikaeli's Analog Clock");
        window.setContentPane(new ClockAnalogBuf());
        //set the minimum size to 800 x 500 pixels
        window.setMinimumSize(new Dimension(800, 500));
        window.pack();        
        window.setResizable(false);                                           // Layout components
        window.setLocationRelativeTo(null);     // Center window.
        //make the frame visible
        window.setVisible(true);


    }
    

    public ClockAnalogBuf() {
        //Create an instance of our new clock component.
        _clock = new Clock();
        
        //Create a layout and add the clock componenet to it
        setLayout(new BorderLayout());
        add(_clock, BorderLayout.CENTER);
        
        //Start the clock 
        start(); 
    }
    
    //start the clock
    @Override public void start() {
        _clock.start();
    }
    
    //stop the clock
    @Override public void stop() {
        _clock.stop();
    }
}