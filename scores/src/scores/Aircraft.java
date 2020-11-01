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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import static scores.JConnection.buildTableModel;
import static scores.JConnection.newline;

/**
 *
 * @author Alice bain
 */
public class Aircraft {
    
     final static String newline = "\n";
    
public static Connection Aircraft(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM aircraft");
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
             String id_user,type_test,color_test,capacity_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the AircraftID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               type_test = (String)JOptionPane.showInputDialog(null, "Enter the Aircraft type of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               color_test = (String)JOptionPane.showInputDialog(null, "Enter the Aircraft color of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               capacity_test = (String)JOptionPane.showInputDialog(null, "Enter theAircraft capacity of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
               
                      
               int t = 1;
               if(t>0) {
               try {
                  int capacity = Integer.parseInt(capacity_test);
                
                String sql = "INSERT INTO aircraft VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_user);
            pstmt.setString(2, type_test);
            pstmt.setString(3,color_test);
             pstmt.setInt(4,capacity);
            pstmt.executeUpdate();
               }catch(IllegalArgumentException m) {
            JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database, or its length extends the current data length assigned in the columns. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
               }
               }
                


 // converts the row index in the view to the appropriate index in the model
        

        
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
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the AircraftID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Your record will be removed.",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from aircraft where Aircraft_ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            try{
            stmt.setString(1, deleteR);
            stmt.executeUpdate();
            }catch(IllegalArgumentException x) {
              JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
                  }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "There seems to be an error with the database connection.","",JOptionPane.INFORMATION_MESSAGE);
         }}
     
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
             String type_test,color_test,capacity_test,id_user;
             id_user = (String)JOptionPane.showInputDialog(null,"Enter the Aircraft_ID of the record you want to edit","Edit record",JOptionPane.INFORMATION_MESSAGE);
      type_test = (String)JOptionPane.showInputDialog(null, "Enter the Aircraft type of the record you want to edit." , "Edit record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               color_test = (String)JOptionPane.showInputDialog(null, "Enter the Aircraft color of the record you want to edit." , "Edit record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               capacity_test = (String)JOptionPane.showInputDialog(null, "Enter the Aircraft capacity of the record you want to edit." , "Edit record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
               try{
               
                int capacity = Integer.parseInt(capacity_test);

                String sql = "UPDATE aircraft SET Color=?, Capacity=?, Aircraft_type=? WHERE Aircraft_ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, color_test);
statement.setInt(2, capacity);
statement.setString(3, type_test);
statement.setString(4, id_user);


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
                    try{
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the AircraftID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from aircraft where Aircraft_ID = ?");    
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