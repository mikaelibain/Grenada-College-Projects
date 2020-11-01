//Create a new Project called DrawPanelTest, and paste the following codes

package drawpanel1;

/**
 *
 * Author Kishon Francis
 * Date: 29/09/17
 * Title: Drawing lines
 */

// DrawPanelTest.java
// Application to display a DrawPanel.
import javax.swing.JFrame;

 public class DrawPanel1{

 public static void main( String[] args ){

 // create a panel that contains our drawing  
 DrawPanel1 panel = new DrawPanel1();  
 // create a new frame to hold the panel  
 JFrame application = new JFrame();  
// set the frame to exit when it is closed
application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

application.add( panel ); 
application.setSize( 250, 250 ); // set the size of the frame 
application.setVisible( true ); // make the frame visible  
} // end main
} // end class DrawPanelTest

