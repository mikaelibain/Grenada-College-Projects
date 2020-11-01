/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlesson;

import java.util.Scanner;

/**
 *
 * @author Mikaeli Bain
 */
public class FirstLesson {


     public static void main(String []args){
        
        String x = "Hello World I l000ove";
        int lastspace = x. lastIndexOf(" ");
        String lastword = x.substring(lastspace, x.length()-1);
        System.out.println(lastword.length());
     }

    
}
