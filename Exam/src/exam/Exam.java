/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Alice bain
 */
public class Exam {
Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
          // show a dialog box promting the user to enter their name
        
        boolean swapStuff = true; // assign a true value to a variable
        
        int tmp; //create variables
        int j = 0; // intger j will be intialised
        
        int [] arr = {6,3,7,2,9,15,3,8,4,5}; //create the array
        System.out.println(Arrays.toString(arr));
        
        while(swapStuff) {//while true
             swapStuff = false;//this will be false
             j++;//this will increment
        for(int i = 0; i < arr.length -j; i++){
           
           if(arr[i] > arr[i+1]) {
               tmp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = tmp;
               
               swapStuff = true;
               
               
               System.out.println(Arrays.toString(arr));  
               
           }
              
           }
           }
        }
    }
