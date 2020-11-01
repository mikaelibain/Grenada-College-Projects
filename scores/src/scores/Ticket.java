package scores;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

/**
 * Author Mikaeli Bain
 * Date: 10/30/17
 * Title:Connect a database to Java
 */

public class Ticket { 
    
   final static String newline = "\n";
    
    
            public static Connection Ticket(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM ticket");
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
             String ticket_id,flight_id,seat_num,price,gate,purchase_type;
              
               ticket_id = (String)JOptionPane.showInputDialog(null, "Enter the Ticket ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               flight_id = (String)JOptionPane.showInputDialog(null, "Enter the Flight ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               seat_num = (String)JOptionPane.showInputDialog(null, "Enter the Seat Number of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               price = (String)JOptionPane.showInputDialog(null, "Enter the Price of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               gate = (String)JOptionPane.showInputDialog(null, "Enter the Gate of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               purchase_type = (String)JOptionPane.showInputDialog(null, "Enter the Purchase Type of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
               
                
    
                
                double pr =Double.parseDouble(price);  
                try {

                String sql = "INSERT INTO ticket VALUES (?,?,?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,ticket_id);
            pstmt.setString(2,flight_id);
            pstmt.setString(3,seat_num);
            pstmt.setDouble(4,pr);
            pstmt.setString(5,gate);
            pstmt.setString(6,purchase_type);

            pstmt.executeUpdate();

            }catch(IllegalArgumentException x) {
              JOptionPane.showMessageDialog(null, "The value that you entered does not match a value in the database. Please try again.","",JOptionPane.INFORMATION_MESSAGE);
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
   
        String deleteR,res;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the Ticket ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
         int dialogButton = JOptionPane.YES_NO_OPTION; 
         int dialogResult = JOptionPane.showConfirmDialog (null, "Your record will be removed.","Remove Record",dialogButton);
      
          try {
              String sql = "delete from ticket where Ticket_ID =?";
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
      String ticket_id,flight_id,seat_num,price,gate,purchase_type;
              
               ticket_id = (String)JOptionPane.showInputDialog(null, "Enter the Ticket ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               flight_id = (String)JOptionPane.showInputDialog(null, "Enter the Flight Number of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               seat_num = (String)JOptionPane.showInputDialog(null, "Enter the Seat Number of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               price = (String)JOptionPane.showInputDialog(null, "Enter the Price of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               gate = (String)JOptionPane.showInputDialog(null, "Enter the Gate of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               purchase_type = (String)JOptionPane.showInputDialog(null, "Enter the Purchase Type of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
               try {
                String sql = "UPDATE ticket SET Flight_ID=?, Seat_Number=?, Price=?, Gate=?, Purchase_type=? WHERE Ticket_ID=?";

                 double pr =Double.parseDouble(price);  

 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,flight_id);
            pstmt.setString(2,seat_num);
            pstmt.setDouble(3,pr);
            pstmt.setString(4,gate);
            pstmt.setString(5,purchase_type);
            pstmt.setString(6,ticket_id);

int rowsUpdated = pstmt.executeUpdate();
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
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the Ticket ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from ticket where Ticket_ID = ?");    
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
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
    
    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
       
    }
       

    return new DefaultTableModel(data, columnNames);

}
     
}
