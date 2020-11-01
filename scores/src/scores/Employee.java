/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import static scores.JConnection.buildTableModel;

/**
 *
 * @author Alice bain
 */
public class Employee {
    
     final static String newline = "\n";
    
    public static Connection Employee(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM employee");
     JTable table = new JTable(buildTableModel(rs));
     table.setEnabled(true);
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea(8, 40);
JScrollPane scrollPane = new JScrollPane(textArea); 
textArea.setEditable(false);
        frame.setMinimumSize(new Dimension(500, 700));
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(new JScrollPane(table));
                       
       
            
                JButton select = new JButton("Select/Higlight");
        select.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
        int selRow =  table.getSelectedRow();
        System.out.println(selRow);
        if(selRow > -1) {
        table.setSelectionBackground(new java.awt.Color(255, 119, 144));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
     }else{
            System.out.println("Ok then.");
        }}
  });
       JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton replace = new JButton("Replace");
        JButton find = new JButton("Find");
        
        
       panel.add(add);
        add.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         
            try {
             String employ_id,airport_id,depart_test,fn_test,ln_test,dob_test;
              
               employ_id = (String)JOptionPane.showInputDialog(null, "Enter the Employee ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               airport_id = (String)JOptionPane.showInputDialog(null, "Enter the Airport ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               depart_test = (String)JOptionPane.showInputDialog(null, "Enter the Department of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               fn_test = (String)JOptionPane.showInputDialog(null, "Enter the First Name of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln_test = (String)JOptionPane.showInputDialog(null, "Enter the Last Name of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               dob_test = (String)JOptionPane.showInputDialog(null, "Enter the Date of Birth of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
           
                try{
                String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employ_id);
            pstmt.setString(2,airport_id);
            pstmt.setString(3,depart_test);
            pstmt.setString(4,fn_test);
            pstmt.setString(5,ln_test);
            pstmt.setString(6, dob_test);

            pstmt.executeUpdate();


            }catch(IllegalArgumentException x) {
              JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
                  }

                 } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "There seems to be an error with the database connection.","",JOptionPane.INFORMATION_MESSAGE);
         }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
        
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the Employee ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Your record will be removed.",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from employee where Employee_ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            try{
            stmt.setString(1, deleteR);
            stmt.executeUpdate();
            }catch(IllegalArgumentException x) {
              JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
                  }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "There seems to be an error with the database connection.","",JOptionPane.INFORMATION_MESSAGE);
         }
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
     String employ_id,airport_id,depart_test,fn_test,ln_test,dob_test;
              
               employ_id = (String)JOptionPane.showInputDialog(null, "Enter the Employee ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               airport_id = (String)JOptionPane.showInputDialog(null, "Enter the Airport ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               depart_test = (String)JOptionPane.showInputDialog(null, "Enter the Department of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               fn_test = (String)JOptionPane.showInputDialog(null, "Enter the First Name of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln_test = (String)JOptionPane.showInputDialog(null, "Enter the Last Name of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               dob_test = (String)JOptionPane.showInputDialog(null, "Enter the Date of Birth of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
               
          try {

                String sql = "UPDATE employee SET Airport_ID=?, Department=?, FName=?, LName=?, Date_of_Birth=? WHERE Employee_ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, airport_id);
statement.setString(2, depart_test);
statement.setString(3, fn_test);
statement.setString(4, ln_test);
statement.setString(5, dob_test);
statement.setString(6,employ_id);



int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
         }catch(IllegalArgumentException x) {
              JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
                  }




         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "There seems to be an error with the database connection.","",JOptionPane.INFORMATION_MESSAGE);
         }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    try {
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the Employee ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from employee where Employee_ID = ?");    
statement.setString(1, fd);   

ResultSet findRS = statement.executeQuery();
ResultSetMetaData disFS = findRS.getMetaData();
int columnsNumber = disFS.getColumnCount();
while (findRS.next()) {
    for (int i = 1; i <= columnsNumber; i++) {
        if (i > 1) System.out.print(",  ");
        String columnValue = findRS.getString(i);
        textArea.append(disFS.getColumnName(i) +":"+ " " + columnValue);
        textArea.append(newline);
        
    }
    System.out.println("");
}
                    }catch(IllegalArgumentException x) {
                            JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
                            }

             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "There seems to be an error with the database connection.","",JOptionPane.INFORMATION_MESSAGE);
         }
         }
     
           
        
});
       panel.add(select);
       panel.add(find);
       JButton refresh = new JButton("Refresh");
       refresh.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
            JOptionPane.showMessageDialog(null, "Your table has been successfully updated!","Refresh completed!", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
       
       
        }
});
        
       panel.add(refresh);
       panel.add(textArea);
      // iterate through the java resultset
      frame.setVisible(true);
      // iterate through the java resultset

    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
        
      return null;
      
    }
}