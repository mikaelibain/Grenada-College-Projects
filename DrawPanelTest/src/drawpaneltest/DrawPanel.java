package drawpaneltest;

/**
 *
 * Author Mikaeli Bain
 * Date: 29/09/17
 * Title: Drawing lines
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawPanel extends JPanel{  
// draws an X from the corners of the panel  9 
    private final static Color color1 = new Color(255,62,105);
    private final static Color color3  = new Color(249,89,121);
@Override
public void paintComponent( Graphics mikaeli ){
// call paintComponent to ensure the panel displays correctly
super.paintComponent( mikaeli );

    //set color of rectangele to a dark pink
    //set retangle shape and position
    mikaeli.setColor( color1); 
    mikaeli.fillRect( 150, 100, 300, 220);
    //oval color is white
    //set oval shape and postion
    mikaeli.setColor(Color.WHITE );  
    mikaeli.fillOval( 150, 102, 294, 214);
    //rounded rectangle is pink
    //set rounded rectangel shape, size and position, as well as the edges
    mikaeli.setColor(color3 );
    mikaeli.fillRoundRect(210, 150, 180, 110, 40, 40);
    //make sans-serif text with my name italicized with a text size of 30
    //map its position
    mikaeli.setColor( Color.WHITE );  
    mikaeli.setFont(new Font("SansSerif", Font.ITALIC, 30));
    mikaeli.drawString("Mikaeli Bain", 222,217);
    
} // end method paintComponent  
} // end class DrawPanel
