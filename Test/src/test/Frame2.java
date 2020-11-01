/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  import javax.swing.*;
  
  public class Frame2
  {
     public static void main(String[] args)
     {
        JFrame f = new JFrame("My First GUI");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1);
         viewOrder.setBounds(50,100,60,30);  
        JLabel productName, productPrice;
        productName = new JLabel("hha");
         productPrice = new JLabel("hha");
        viewOrder.add(productName);
        viewOrder.add(productPrice);
        f.add(viewOrder);
   

       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);


        f.setVisible(true);
     }
  }
