/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apple;

/**
 *
 * @author Alice bain
 */
public class Apple {

    /**
     * @param args the command line arguments
     */
    //you're creating the array for your numbers. It has nothing in it.
    static void Apple(int[] arr) {
        // TODO code application logic here
        int n = arr.length;
        int temp = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <(n -i); j++){
                if(arr[j-1] > arr[j]) {
                temp = arr[j-1];
                arr[j-1]= arr[j];
                arr[j] = temp;
            
            }
        }
        
    }
    
}
}
