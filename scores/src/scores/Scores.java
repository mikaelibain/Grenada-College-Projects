package scores;

import java.awt.Dimension;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


/**
 * Author Kishon Francis
 * Date: 10/30/17
 * Title:Connect a datebase to Java
 */
public class Scores extends JFrame {
    protected JPasswordField passwordField;
    public static void login() {
          JFrame frame = new JFrame();
          JPanel panel = new JPanel();
        frame.setMinimumSize(new Dimension(800, 500));
        frame.pack();
        frame.add(panel);
      
        JLabel intro = new JLabel("Hello! To view the database, please enter your username and password.");
        JTextField un = new JTextField(22);
        
        JPasswordField field = new JPasswordField();
        field.setColumns( 20 );
        JButton enter = new JButton("Login");
        enter.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String user = un.getText();
            String password = field.getText();
      
       if (user.equals("Mikaeli Bain") && password.equals("airport")){
           JOptionPane.showMessageDialog(null, "You have successfully logged in!");
           frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
           Scores a = new Scores();
       }else {
           JOptionPane.showMessageDialog(null,"Sorry, but you have entered the wrong password/username. Please try again.");
       }   
 
        }
    });
       panel.add(intro);
       panel.add(un);
       panel.add(field);
       panel.add(enter);
       frame.setVisible(true);
       
    }

    public void TryingMyBestHere() {
            JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 500));
        frame.pack();         
        frame.setVisible(true);
    }
    public Scores() {

        setTitle("Airport Database");
        setSize(600, 600);

        // Create JButton and JPanel
        JLabel intro = new JLabel("Hello! Welcome to the airport database.To view a table, please select the buttons below.");
          JButton button = new JButton("Aircraft Table");
                button.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         Connection conn = null;
        conn = Aircraft.Aircraft();
     }
  });

        JButton button2 = new JButton("Airport Table");
                button2.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         Connection conn = null;
        conn = Airport.Airport();
     }
  });
                 JButton button3 = new JButton("Employee Table");
                button3.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         Connection conn = null;
        conn = Employee.Employee();
     }
  });
                
                 JButton button4 = new JButton("Flight Table");
                button4.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         Connection conn = null;
        conn = Flight.Flight();
     }
  });
                
                 JButton button5 = new JButton("Ticket Table");
                button5.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         Connection conn = null;
        conn = Ticket.Ticket();
     }
  });
        JPanel panel = new JPanel();
        panel.add(intro);
// Add button to JPanel
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        

        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

            
    public static void main(String[] args) {
        
        Scores.login();
        
        

        // TODO add your handling code here:
    }   
    

     
}

