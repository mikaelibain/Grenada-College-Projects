
package bubblesort;

import java.util.Arrays;

/**
 *
 * @author Alice bain
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

      boolean swapped = true;

      int j = 0;

      int tmp;

      int arr[] = {1,2,7,3,6,5,9,4};
      System.out.println("Before swapping.");
      System.out.println(Arrays.toString(arr));
      while (swapped) {

            swapped = false;

            j++;

            for (int i = 0; i < arr.length - j; i++) {                                       

                  if (arr[i] > arr[i + 1]) {                          

                        tmp = arr[i];

                        arr[i] = arr[i + 1];

                        arr[i + 1] = tmp;

                        swapped = true;
                        System.out.println("After swapping");
                        System.out.println(Arrays.toString(arr));

                  }

            }                

      }

    }
    
}
