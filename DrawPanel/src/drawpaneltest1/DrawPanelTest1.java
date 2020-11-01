//Create a new class called DrawPanel, and paste the following codes



package drawpaneltest;

/**
 *
 * Author Kishon Francis
 * Date: 29/09/17
 * Title: Drawing lines
 */
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawPanelTest extends JPanel{  
// draws an X from the corners of the panel  9 
@Override
public void paintComponent( Graphics g ){
// call paintComponent to ensure the panel displays correctly
super.paintComponent( g );

 int width = getWidth(); // total width  
 int height = getHeight(); // total height 
// draw a line from the upper-left to the lower-right
g.drawRect( 20, 40, 60, 60 );

// draw a line from the lower-left to the upper-rightg.drawLine( 0, height, width, 0 ); 
} // end method paintComponent  
} // 