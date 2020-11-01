/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gradecalc;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.*;
/**
 *
 * @author Mikaeli bain
 */

public class fibonacci 
{ 
   public static void main (String [] args){
       int [] NumArray = new int [20];
           for (int y = 1; y < 20; y++) {
               int ans = PrimeCheck(y);
           
           System.out.println(ans);
           }
           
       }
        public static int PrimeCheck(int x) {
            int count = 0;
            for(int z = 1; z < 20; z++) {
                if (x % z == 0) {
                    count =  count + 1;
                    
                   
                } else {
                     count = count + 0;
                     
                }
                

                
            }
            System.out.println(count);
             return x;
        }
            
}


  