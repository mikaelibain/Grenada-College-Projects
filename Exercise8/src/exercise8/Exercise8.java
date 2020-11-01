/*
Author: Mikaeli Bain
Program: JAVA Programming
Date: 17/11/2017
*/
package exercise8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alice bain
 */
   public class Exercise8 extends JPanel implements ActionListener  { 
       
    protected JTextField textField;    
    protected JPasswordField passwordField;
    protected JTextArea textArea;  
    private final Component scrollPane; 
    private final static String newline = "\n"; 
    
    public Exercise8() { 
       JLabel myLabel, password; 
       //this component allows the editing of a single line of text.
       textArea = new JTextArea(6, 25);
       //this prevents the text from being edited
        textArea.setEditable(false);  
        //the images are created
        ImageIcon password1 = createImageIcon("lock.gif");
        ImageIcon input = createImageIcon("input.gif");
        //Attach the images to the label
        myLabel = new JLabel("Input the text" , input,  JLabel.LEFT);
        password = new JLabel("Input the password",password1,JLabel.LEFT);
        //the input restricts the number of characters t0 22
        textField = new JTextField(22);        
        textField.addActionListener(this); 
        //it restricts the numbers of characters in the password field to 16
        passwordField = new JPasswordField(16);
        passwordField.addActionListener(this);
        textArea.setEditable(false);
        //this component enables a scrollpane to be enabled so that the text doesn't lose it's structure
          scrollPane = new JScrollPane(textArea); 
        //Add Components to this panel.        
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridLayout (0,1));
        add(myLabel, c);
        add(password, c);
        add(textField, c);  
        add(passwordField, c);
        add(scrollPane, c);  
    }     //  end MyText


private static void createFrame() {        
               //Create and set up the window.        
        JFrame frame = new JFrame("Mikaeli Bain");        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
               //Add contents to the window.        
        frame.add(new Exercise8());         
             //Display the window.        
        frame.pack();   
        frame.setVisible(true);    
    }     // end createFrame
public static void main (String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {            
                public void run() {                
                    createFrame();            
                }        
            });    
    }     // end main
//create event handler
public void actionPerformed(ActionEvent evt) {        
       String text = textField.getText();   
       String text1 = passwordField.getText();    
        textArea.append(text + newline);
        textField.selectAll();
        textField.cut();   
        text1 = passwordField.getText();    
       JOptionPane.showMessageDialog(null,
            "Text: " + text +"\n Password: " + text1);


}
//this method finds the specified file and returns an ImageIcon for that file
         protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = Exercise8.class.getResource(path);  
            if (imgURL != null) {
            return new ImageIcon(imgURL);
            } else {
//if the file cannot be found, print out "couldn't find file" to the console and return a null value
            System.err.println("Couldn't find file: " + path);  return null;
            }
        }

}
