/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeview;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingContainerDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingContainerDemo(){
      prepareGUI();
   }
   
   public static void main(String[] args){
      SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();  
      Linklist1 theLinkedList = new Linklist1();
        
        theLinkedList.insertFirstLink("Bread",500);
        theLinkedList.insertFirstLink("Cake",200);
        theLinkedList.insertFirstLink("Pizza",150);
        theLinkedList.insertFirstLink("Puff Pastry",100);
        //find something in linked list
        System.out.println(theLinkedList.find("Bread").bookName + " Was found " +" - This is a seacrh");
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Products");
      mainFrame.setSize(800,800);
      
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
    
      msglabel = new JLabel("Panike", JLabel.CENTER);
   
      controlPanel = new JPanel();
     
      mainFrame.add(msglabel);
      mainFrame.setVisible(true); 
      mainFrame.setLocationRelativeTo(null);
      
   }
   /* @author josiahc2016 */
public class Linklist {
    public String bookName;
    public int millionsSold;
    
    public Linklist next;
    
    public Linklist(String bookName, int millionsSold){
    
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }
    
    public void display(){
    
        System.out.println(bookName + ": " + millionsSold + ",000,000") ;
    }
    
    public String toString(){
    
        return bookName;
    }
    

    
}


}