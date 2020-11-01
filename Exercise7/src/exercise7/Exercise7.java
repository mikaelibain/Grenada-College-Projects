
/**
 *
 * Author Mikaeli Bain
 * Date: 10/11/17
 * Title: Exercise 7
 */
package exercise7;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exercise7 extends JFrame {

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
        JFrame frame = new JFrame("Mikaeli's WorkWithJLabels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);  
        //create icons
      ImageIcon hello = createImageIcon("melon.gif");
      ImageIcon surf = createImageIcon("surf.gif");
         //Create the labels
      JLabel label1 = new JLabel(hello);
      JLabel label2 = new JLabel( "Gif of a surfer", surf,
                  JLabel.LEFT );
      //set the position for the second label
 label2.setHorizontalTextPosition(JLabel.CENTER);
    label2.setVerticalTextPosition(JLabel.BOTTOM);
    label2.setToolTipText( "This is a surf gif that is 125 * 125!" );
    //add the labels to the JFrame
        frame.getContentPane().add(label1);
        frame.getContentPane().add(label2);
        //Display the window.
        frame.pack();
        //Set the size of the frame to 800*500 pixels
        frame.setSize(800,500);
        frame.setVisible(true);
    }    // end createAndShowGUI
 //this method finds the specified file and returns an ImageIcon for that file
     protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = Exercise7.class.getResource(path);  if (imgURL != null) {
            return new ImageIcon(imgURL);
            } else {
//if the file cannot be found, print out "couldn't find file" to the console and return a null value
            System.err.println("Couldn't find file: " + path);  return null;
            }
        }// end createAndShowGUI
}

