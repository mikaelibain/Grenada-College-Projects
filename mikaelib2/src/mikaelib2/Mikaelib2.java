/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mikaelib2;
import javax.swing.*;
import java.io.File;

public class Mikaelib2 {

    static Object[] pizza = {"Vegetarian", "Pepperoni", "Meat Lovers","Extra Cheese"};
   
    static Object[] drink = {"Cola", "Champagne", "Water","Smoothies", "Juice", "none"};
    
    public static void main(String[] args) {
       //Set variable type for images (gif)
        ImageIcon hello, pizzaPic,drinkPic, catPic, cat1Pic, sadCat;
        
        //set variable type to string
        String userName, pizzaName, drinkName, wantName;
        
        //set variable values to the image
        hello = new ImageIcon("Mikaeli Bain Pics" + File.separator + "hello.gif");
        
        pizzaPic = new ImageIcon("Mikaeli Bain Pics" + File.separator + "pizza.gif");
        
        drinkPic = new ImageIcon("Mikaeli Bain Pics" + File.separator + "drink 1.gif");
        
        catPic = new ImageIcon ("Mikaeli Bain Pics" + File.separator +"cat.gif");
        
        cat1Pic = new ImageIcon ("Mikaeli Bain Pics" + File.separator +"cat 1.gif");
        
        sadCat = new ImageIcon ("Mikaeli Bain Pics" + File.separator +"sad cat.gif");
        
         // show a dialog box promting the user to enter their name
        userName = (String)JOptionPane.showInputDialog(null, "What is your name?" , "Welcome", JOptionPane.INFORMATION_MESSAGE, hello, null, null);
        
        pizzaName = (String)JOptionPane.showInputDialog(null,"What type of pizza do you prefer", "I like pizza!",JOptionPane.INFORMATION_MESSAGE, pizzaPic , pizza,  pizza[0] );
        
        drinkName = (String)JOptionPane.showInputDialog(null,"What type of drimk do you want", "Thirsty?", JOptionPane.INFORMATION_MESSAGE, drinkPic , drink , drink[0]  );
        
        wantName = (String)JOptionPane.showInputDialog(null,"Would you like anything else?", "Shop till you drop!", JOptionPane.INFORMATION_MESSAGE, catPic , null,  null);
        
        //if the user doesn't enter anything, prompt the user to enter a response by showing a message asking them to
        while(wantName.equals("")) {
             wantName = (String)JOptionPane.showInputDialog(null, "You need to give an answer!", "Hold on!", JOptionPane.INFORMATION_MESSAGE, sadCat, null, null);
      }
        
        //a switch staement to handle special cases       
              
        switch (wantName) {
            //if user enters these choices. the final message box will omitt their last response
            case "no":
            case "nothing":
            case "none":
            case "nah":
                JOptionPane.showMessageDialog(null, userName + " wants " + pizzaName + " and " + drinkName +" .", "Thank you!", JOptionPane.PLAIN_MESSAGE, cat1Pic );
                break;
             //if the user says yes, prompt the user with a message box to make them respond
            case "yes":
            case "yeah":
            case "okay":
                wantName = (String) JOptionPane.showInputDialog(null, "Please enter the name of the item!", "Hold on!", JOptionPane.INFORMATION_MESSAGE, sadCat, null, null);
                
                 JOptionPane.showMessageDialog(null, userName + " wants " + pizzaName + ", " + drinkName + " and " + wantName + ".", "Thank you!", JOptionPane.PLAIN_MESSAGE, cat1Pic );
                break;
             //otherwise, display the final message withh all the answers
            default:
                JOptionPane.showMessageDialog(null, userName + " wants " + pizzaName + ", " + drinkName + " and " + wantName + ".", "Thank you!", JOptionPane.PLAIN_MESSAGE, cat1Pic );
                break;
        }
    }
 }
    
