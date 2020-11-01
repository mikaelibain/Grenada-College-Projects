/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise5;
import javax.swing.JOptionPane;

/**
 *
 * @author Alice bain
 */
public class Exercise5 {
    //object that holds all the sexes
static Object[] gender = {"male", "female"};


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Input boxes asks for the user's name and age
        String name = (String)JOptionPane.showInputDialog(null, "Hello, welcome to the Divider! What is your name?" , "Welcome!", JOptionPane.INFORMATION_MESSAGE, null,null,null);
        String age = (String)JOptionPane.showInputDialog(null, "What is your age?" , "Welcome, " + name, JOptionPane.INFORMATION_MESSAGE, null,null,null);
        boolean bError = true;   
        //try/catch block to prevent anything other than integers to be accepted
        do {
        try {
            age = (String)JOptionPane.showInputDialog(null, "What is your age?" , "Welcome, " + name, JOptionPane.INFORMATION_MESSAGE, null,null,null);
            int age4 = Integer.parseInt(age);
            bError = false;
            
        } 
        catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null,"Please enter an interger.","Sorry!", JOptionPane.INFORMATION_MESSAGE);
           
        }
    }while (bError);
        //Ask for the user's sex
        String sex = (String)JOptionPane.showInputDialog(null, "What is your sex?" , "What is your sex, " + name, JOptionPane.INFORMATION_MESSAGE, null,gender,gender[0]);
        String title;
        if(sex.equals("male")){
            title = "Mr. ";
        }else {
             title = "Ms. ";
        }
        //Explain the rules using a messagebox
        JOptionPane.showMessageDialog(null, "Welcome to divider, " +title + name + ".\nOk, here are the rules, "+ name + ".\nThe divider is a game where you have to input two numbers, and the program will divide them.\nBecause you are "+age +" years old, any number of yours will be divided by " + age + ", your age." , "Rules!", JOptionPane.INFORMATION_MESSAGE);
        String input = (String)JOptionPane.showInputDialog(null, "Please enter any number, " + title+name+"." , "Numbers, Numbers, where are you?", JOptionPane.INFORMATION_MESSAGE, null,null,null);
        boolean bError1= true;   
        //exception handling to not except any values that are not numbrs
        do {
        try {
            input = (String)JOptionPane.showInputDialog(null, "Please enter any number, " + title+name+"." , "Numbers, Numbers, where are you?", JOptionPane.INFORMATION_MESSAGE, null,null,null);
            double input1 = Double.parseDouble(input);
            bError1 = false;
        } 
        catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null,"Please enter a number.","Sorry!", JOptionPane.INFORMATION_MESSAGE);
           
        }
    }while (bError1);
         //parse the string values into double data types so the quotient can be determined
         double input1 = Double.parseDouble(input);
         double age1 = Double.parseDouble(age);
         double ans = input1 / age1;
         //show the answer
         //wish the user goodnight
         JOptionPane.showMessageDialog(null,"The answer is " + ans, "Answer", JOptionPane.INFORMATION_MESSAGE); 
         JOptionPane.showMessageDialog(null,"Goodbye, " + name + "!", "Goodbye!", JOptionPane.INFORMATION_MESSAGE); 
    }
    
}
