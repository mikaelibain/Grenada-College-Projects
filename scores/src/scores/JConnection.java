
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

public class JConnection { 
    
   final static String newline = "\n";
    public static Connection Aircraft(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonix", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM users");
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
             String id_user,FN_test,LN_test,age_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               FN_test = (String)JOptionPane.showInputDialog(null, "Enter the Pscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               LN_test = (String)JOptionPane.showInputDialog(null, "Enter the Cscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age_test = (String)JOptionPane.showInputDialog(null, "Enter the Tscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
                
                int ID_USERS = Integer.parseInt(id_user);
                int age = Integer.parseInt(age_test);
                
                String sql = "INSERT INTO users VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID_USERS);
            pstmt.setString(2,FN_test);
            pstmt.setString(3,LN_test);
            pstmt.setInt(4, age);

            pstmt.executeUpdate();


 // converts the row index in the view to the appropriate index in the model
        

        }catch(Exception bruh) {
            System.out.println("You messed up.");
        }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
             int viewIndex = table.getSelectedRow();
    if(viewIndex != -1) {
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Are you sure you want to delete this record",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from users where ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int deleted = Integer.parseInt(deleteR);
            stmt.setInt(1, (int) deleted);
            stmt.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)table.getModel();
        }catch(SQLException bruh) {
            System.out.println("You messed up.");
        }}
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
      String up,fn,ln,age;
              
               up = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
              
               fn = (String)JOptionPane.showInputDialog(null, "Edit the first name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln = (String)JOptionPane.showInputDialog(null, "Edit the last name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age = (String)JOptionPane.showInputDialog(null, "Edit the age cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null); 
               
                int ID_USERS = Integer.parseInt(up);

                String sql = "UPDATE Users SET FirstName=?, LastName=?, Age=? WHERE ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, fn);
statement.setString(2, ln);
statement.setString(3, age);
statement.setInt(4, ID_USERS);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
       
  



        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
                }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from users where ID = ?");    
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


             
        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
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
    public static Connection Airport(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonix", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM users");
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
             String id_user,FN_test,LN_test,age_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               FN_test = (String)JOptionPane.showInputDialog(null, "Enter the Pscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               LN_test = (String)JOptionPane.showInputDialog(null, "Enter the Cscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age_test = (String)JOptionPane.showInputDialog(null, "Enter the Tscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
                
                int ID_USERS = Integer.parseInt(id_user);
                int age = Integer.parseInt(age_test);
                
                String sql = "INSERT INTO users VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID_USERS);
            pstmt.setString(2,FN_test);
            pstmt.setString(3,LN_test);
            pstmt.setInt(4, age);

            pstmt.executeUpdate();


 // converts the row index in the view to the appropriate index in the model
        

        }catch(Exception bruh) {
            System.out.println("You messed up.");
        }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
             int viewIndex = table.getSelectedRow();
    if(viewIndex != -1) {
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Are you sure you want to delete this record",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from users where ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int deleted = Integer.parseInt(deleteR);
            stmt.setInt(1, (int) deleted);
            stmt.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)table.getModel();
        }catch(SQLException bruh) {
            System.out.println("You messed up.");
        }}
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
      String up,fn,ln,age;
              
               up = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
              
               fn = (String)JOptionPane.showInputDialog(null, "Edit the first name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln = (String)JOptionPane.showInputDialog(null, "Edit the last name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age = (String)JOptionPane.showInputDialog(null, "Edit the age cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null); 
               
                int ID_USERS = Integer.parseInt(up);

                String sql = "UPDATE Users SET FirstName=?, LastName=?, Age=? WHERE ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, fn);
statement.setString(2, ln);
statement.setString(3, age);
statement.setInt(4, ID_USERS);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
       
  



        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
                }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from users where ID = ?");    
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


             
        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
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
        public static Connection Employee(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonix", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM users");
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
             String id_user,FN_test,LN_test,age_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               FN_test = (String)JOptionPane.showInputDialog(null, "Enter the Pscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               LN_test = (String)JOptionPane.showInputDialog(null, "Enter the Cscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age_test = (String)JOptionPane.showInputDialog(null, "Enter the Tscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
                
                int ID_USERS = Integer.parseInt(id_user);
                int age = Integer.parseInt(age_test);
                
                String sql = "INSERT INTO users VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID_USERS);
            pstmt.setString(2,FN_test);
            pstmt.setString(3,LN_test);
            pstmt.setInt(4, age);

            pstmt.executeUpdate();


 // converts the row index in the view to the appropriate index in the model
        

        }catch(Exception bruh) {
            System.out.println("You messed up.");
        }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
             int viewIndex = table.getSelectedRow();
    if(viewIndex != -1) {
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Are you sure you want to delete this record",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from users where ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int deleted = Integer.parseInt(deleteR);
            stmt.setInt(1, (int) deleted);
            stmt.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)table.getModel();
        }catch(SQLException bruh) {
            System.out.println("You messed up.");
        }}
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
      String up,fn,ln,age;
              
               up = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
              
               fn = (String)JOptionPane.showInputDialog(null, "Edit the first name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln = (String)JOptionPane.showInputDialog(null, "Edit the last name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age = (String)JOptionPane.showInputDialog(null, "Edit the age cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null); 
               
                int ID_USERS = Integer.parseInt(up);

                String sql = "UPDATE Users SET FirstName=?, LastName=?, Age=? WHERE ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, fn);
statement.setString(2, ln);
statement.setString(3, age);
statement.setInt(4, ID_USERS);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
       
  



        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
                }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from users where ID = ?");    
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


             
        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
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
     
        public static Connection Flight(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonix", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM users");
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
             String id_user,FN_test,LN_test,age_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               FN_test = (String)JOptionPane.showInputDialog(null, "Enter the Pscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               LN_test = (String)JOptionPane.showInputDialog(null, "Enter the Cscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age_test = (String)JOptionPane.showInputDialog(null, "Enter the Tscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
                
                int ID_USERS = Integer.parseInt(id_user);
                int age = Integer.parseInt(age_test);
                
                String sql = "INSERT INTO users VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID_USERS);
            pstmt.setString(2,FN_test);
            pstmt.setString(3,LN_test);
            pstmt.setInt(4, age);

            pstmt.executeUpdate();


 // converts the row index in the view to the appropriate index in the model
        

        }catch(Exception bruh) {
            System.out.println("You messed up.");
        }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
             int viewIndex = table.getSelectedRow();
    if(viewIndex != -1) {
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Are you sure you want to delete this record",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from users where ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int deleted = Integer.parseInt(deleteR);
            stmt.setInt(1, (int) deleted);
            stmt.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)table.getModel();
        }catch(SQLException bruh) {
            System.out.println("You messed up.");
        }}
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
      String up,fn,ln,age;
              
               up = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
              
               fn = (String)JOptionPane.showInputDialog(null, "Edit the first name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln = (String)JOptionPane.showInputDialog(null, "Edit the last name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age = (String)JOptionPane.showInputDialog(null, "Edit the age cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null); 
               
                int ID_USERS = Integer.parseInt(up);

                String sql = "UPDATE Users SET FirstName=?, LastName=?, Age=? WHERE ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, fn);
statement.setString(2, ln);
statement.setString(3, age);
statement.setInt(4, ID_USERS);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
       
  



        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
                }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from users where ID = ?");    
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


             
        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
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
         public static Connection Ticket(){ //this is users
        

    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonix", "root", "");
            System.out.print("Database Connected\n");


    // It creates and displays the table


    // Closes the Connection

         
      // create the java statement
      Statement st = conn.createStatement();
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery("SELECT * FROM users");
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
             String id_user,FN_test,LN_test,age_test;
              
               id_user = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               FN_test = (String)JOptionPane.showInputDialog(null, "Enter the Pscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               LN_test = (String)JOptionPane.showInputDialog(null, "Enter the Cscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age_test = (String)JOptionPane.showInputDialog(null, "Enter the Tscore of the record you want to add." , "Add Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
    
                
                int ID_USERS = Integer.parseInt(id_user);
                int age = Integer.parseInt(age_test);
                
                String sql = "INSERT INTO users VALUES (?,?,?,?) ";
 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID_USERS);
            pstmt.setString(2,FN_test);
            pstmt.setString(3,LN_test);
            pstmt.setInt(4, age);

            pstmt.executeUpdate();


 // converts the row index in the view to the appropriate index in the model
        

        }catch(Exception bruh) {
            System.out.println("You messed up.");
        }
     }
  });
       panel.add(remove);
       remove.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
   
             int viewIndex = table.getSelectedRow();
    if(viewIndex != -1) {
        String deleteR;
         deleteR = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to remove." , "Remove Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
           JOptionPane.showMessageDialog(frame,
    "Are you sure you want to delete this record",
    "Delete Record",
    JOptionPane.WARNING_MESSAGE);
          try {
              String sql = "delete from users where ID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int deleted = Integer.parseInt(deleteR);
            stmt.setInt(1, (int) deleted);
            stmt.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)table.getModel();
        }catch(SQLException bruh) {
            System.out.println("You messed up.");
        }}
     }
  });
       
        panel.add(replace);
        replace.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
         try {
      String up,fn,ln,age;
              
               up = (String)JOptionPane.showInputDialog(null, "Enter the ID of the record you want to edit." , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
              
               fn = (String)JOptionPane.showInputDialog(null, "Edit the first name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               ln = (String)JOptionPane.showInputDialog(null, "Edit the last name cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               age = (String)JOptionPane.showInputDialog(null, "Edit the age cell" , "Edit Record", JOptionPane.INFORMATION_MESSAGE, null, null, null); 
               
                int ID_USERS = Integer.parseInt(up);

                String sql = "UPDATE Users SET FirstName=?, LastName=?, Age=? WHERE ID=?";

PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, fn);
statement.setString(2, ln);
statement.setString(3, age);
statement.setInt(4, ID_USERS);

int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
	JOptionPane.showMessageDialog(null, "The record was updated successfully" , "Edit Record", JOptionPane.INFORMATION_MESSAGE);
}
          
       
  



        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
                }
         }
     
  });
        find.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
                    try {
                    String fd; 
                    fd= (String)JOptionPane.showInputDialog(null, "Please enter the ID of the record you want to find" , "Find Record", JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
                	

PreparedStatement statement = conn.prepareStatement("select * from users where ID = ?");    
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


             
        }catch(Exception bruh) {
            System.out.println("You messed up.");
        
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
