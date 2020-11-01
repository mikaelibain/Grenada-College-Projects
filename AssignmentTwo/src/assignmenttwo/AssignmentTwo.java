/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Mikaeli Bain
 */
public class AssignmentTwo {
 
  
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        //the arrays are initilised with their sizes
        String[] acctname = new String[5];
        double[] balance= new double[5];
        //prompt the user to enter five account members and their amounts
        System.out.println("Hello there! You will now enter the names of 5 people and their account balances.");
            //this loop reads and saves the input data to two parallel arrays
            for (int i = 0; i < 5; i++) { 
                System.out.println("User, please enter a name.");
                //Saves the input to a variable
                String n = keyboard.next();
                //the variable is then saved to the array
                acctname[i] = n;
                
                System.out.println("User, please enter an amount: ");
                double money = 0;
                boolean repeat = true;
		/*Exception Handling where if the user enters a non numericial value, the program will not move on to
	          the next step unless the user enters a numerical value */
                    while(repeat) {
                        try{
                            money = keyboard.nextDouble();
                            repeat = false;
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a numerical value");
                            keyboard.next();   // or scanner.nextLine()
                            repeat = true;
                        }
                    }
            balance[i] = money;    
        }
              
        //after reading the input of the user and saving it in an array, I printed the array
        print(acctname, balance);
        //I then arranged the array in alphabetical order using my method which sorts the parallel arrays according to acctname
        selectSort(acctname, balance);
        //print the alphabetically sorted arrays
        print(acctname, balance);
        //prints the sum off all the balnces in the array
        total(balance);
    }
       // Function which implements selection sort 
    public static void selectSort(String name[],double balance[]) { 
        System.out.println("The array arranged in alphabetical order is: \n"); 
        //initialing the variables for the loops
        int i, j;
        //initialising the temporary variable to store the values for the swap
        double tempAmount;
        String temp;
            //this loop goes through all the values in the arrays
            for ( i = 0;  i < name.length - 1;  i++ )
            {
                //this loop sets j as the value directly next to y
                for ( j = i + 1;  j < name.length;  j++ )
                {
                    /*if the first value is greater than the second value,the result will be greater than zero
                    and the block will execute to swap the values */
                         if ( name [ i ].compareToIgnoreCase( name [ j ] ) > 0 )
                            {           //using a temporary value to store the larger string value before swapping                                  
                                      temp = name[ i ];
                                       //using a temporary value to store the user's amount before swapping         
                                      tempAmount = balance[i];
                                      name [ i ] = name [ j ];    // swapping the larger name value with the smaller name value
                                      balance[i] = balance[j];    //swapping the larger balances  with the smaller balance
                                      name [ j ] = temp;        //storing the larger value that was saved in the temporary variable in the position of the smaller value
                                      balance[j]  = tempAmount; //storing the larger value that was saved in the temporary variable in the position of the smaller value
                                     
                           }
                   }
             }
      
        }
       
    //this method prints the name and balance for each customer
    public static void print(String name[],double balance[]) {
            //iterates through the arrays
        for (int i = 0; i < 5; i++) { 
            //gets the values of each of the arrays by pulling the values of the indexes we are accessing and prints out the values
            System.out.println(name[i] + "'s balance is " + balance[i] ); 
        } 
        System.out.println( "\n"); 
    } 
//this method returns the total of the balances
    public static void total(double [] balance) { 
        //intialise total to zero
       double total = 0;
       //iterates through the balance arrays, adding every entry together to get a total
        for (int i = 0; i < 5; i++) { 
            total = total + balance[i];
        } 
        System.out.println( "The total of all the balances is: " + total);
    } 
    
}
