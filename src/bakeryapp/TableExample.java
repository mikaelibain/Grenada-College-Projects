/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryapp;

/**
 *
 * @author Alice bain
 */

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
public class TableExample extends JFrame
{
     
    public TableExample()
    {
        String[] columns={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(columns,0);
JTable tbl=new JTable(dtm);

        //headers for the table
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"", "John", 2, false },
            {"", "Rambo", 2, false },
            {"", "Zorro", 60.0, true },
        };
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }
        });
    }   
}