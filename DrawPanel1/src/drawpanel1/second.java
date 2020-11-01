/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpanel1;


/**
 *
 * Author Kishon Francis
 * Date: 29/09/17
 * Title: Drawing lines
 */
import java.awt.Graphics;
import javax.swing.JPanel;


public class second extends JPanel{  
// draws an X from the corners of the panel  9 
@Override
public void paintComponent( Graphics g ){
// call paintComponent to ensure the panel displays correctly
super.paintComponent( g );

 int width = getWidth(); // total width  
 int height = getHeight(); // total height 
// draw a line from the upper-left to the lower-right
g.drawRect( 0, 0, width, height );

// draw a line from the lower-left to the upper-right
g.drawLine( 0, height, width, 0 ); 
} // end method paintComponent  
} // end class DrawPanel