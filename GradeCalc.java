
package gradecalc;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.*;
/**
 *
 * @author Mikaeli bain
 */
public class GradeCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Gets the input of the user
        Scanner keyboard = new Scanner(System.in);
        //prompt the user for the data and reads the data
        System.out.println("Please enter a grade:  ");
        int num = keyboard.nextInt();
        int high = num, low = num;
        int sum = 0, count = 0;
        double average = 0;

        /**until the user's input is less than 1 or greater than 100  (WHICH IS OUSTIDE THE PARAMETERS OF EXAM SCORES)
        use the methods to calculate the average, highest and lowest grades of the exam
        */
         while (num >= 0 && num <= 100){ 
            high = highNum(high,num);
            low = lowNum(low,num);

            sum = sum + num;
            count++;
            average = ((double) sum) / count;
            //Output the highest, lowest and running total as you go
         System.out.println("The average grade of the exam so far is: " + average);
         System.out.println("The highest grade in the exam so far is: " + high);
         System.out.println("The lowest grade inthe exam so far is: " + low);
         //Propmt the user for the next number
            System.out.println("Please give me the next number. ");
            num = keyboard.nextInt();
            
        }
         //Outputs the final results from the exams
         System.out.println("The average grade of the exam is: " + average);
         System.out.println("The highest grade in the exam is: " + high);
         System.out.println("The lowest grade inthe exam is: " + low);
    
    }
    //create a method that calculates the highest grade of the exam
    public static int highNum(int x, int y) {
        int sum = max(x,y);
        return sum;
    }
   
     //create a method that calculates the lowest grade of the exam
    public static int lowNum(int x, int y) {
        int sum = min(x,y);
        return sum;
    }
    
}
