/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculusbuddie;
import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author Alice bain
 */
public class Calculusbuddie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        char var;
        int num;
        String in;
        System.out.println("Please enter the values for the limit");
        var = keyboard.next().charAt(0);
        num = keyboard.next().charAt(0);
        in = keyboard.next();   
        String x = in. replaceAll("\\s","");
Pattern pattern = Pattern.compile("\\+");
String[] result = pattern.split(x);
System.out.println(Arrays.toString(result));
    }

    }
    

