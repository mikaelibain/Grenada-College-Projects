/*Name: Mikaeli Bain
  Assignment Three
  9th October 2019
*/

import java.util.InputMismatchException;
import java.util.Scanner;


public class AssignmentThreel {

        public static void main(String[] args) {
             Scanner keyboard = new Scanner(System.in);
             Account[] bank = new Account[5];
             
             String aname;
             double bal;
             for (int i = 0; i < bank.length; i++){
                 System.out.println("User, please enter a name.");
                //Saves the input to a variable
                aname = keyboard.next();
                //the variable is then saved to the array
                System.out.println("User, please enter an amount: ");
                bal= 0;
                boolean repeat = true;
		/*Exception Handling where if the user enters a non numericial value, the program will not move on to
	          the next step unless the user enters a numerical value */
                    while(repeat) {
                        try{
                            bal = keyboard.nextDouble();
                            repeat = false;
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a numerical value");
                            keyboard.next();   // or scanner.nextLine()
                            repeat = true;
                        }
                    }
           bank[i] = new Account(aname, bal);
        }            
        print(bank);
        selectSort(bank);
        print(bank);
        total(bank);
   }
   public static class Account {
    private String acctname;
    private double balance;
        Account(String nm, double bal) {
            acctname = nm;
            balance = bal;
         }

           double getBalance() { 
             return balance;
         }
           String getAcctname() { 
             return acctname;
         }
           void setAcctname(String a) {
               acctname = a;
         }

         void setBalance(double b) { 
             balance = b;
         }
  }

     // Function which implements selection sort 
    public static void selectSort(Account b[]) { 
        System.out.println("The array arranged in alphabetical order is: \n"); 
        //initialing the variables for the loops
        Account temp;
                int i, j;
        //initialising the temporary variable to store the values for the swap
            //this loop goes through all the values in the arrays
            for ( i = 0;  i < b.length - 1;  i++ )
            {
                //this loop sets j as the value directly next to y
                for ( j = i + 1;  j < b.length;  j++ )
                {
                  if ( b [ i ].getAcctname().compareTo( b [ j ].getAcctname() ) > 0 )
                          {
                                      temp = b[i];
                                        b[i] = b[j];
                                        b[j] = temp;
                          }
                   }
             }
      
        }
    

    public static void print(Account b[]) {
             //iterates through the arrays
        System.out.println( "\n"); 
        for (int i = 0; i < 5; i++) { 
            //gets the values of each of the arrays by pulling the values of the indexes we are accessing and prints out the values
              System.out.println(b[i].getAcctname() + "'s balance is " + b[i].getBalance());
              ; 
        } 
        System.out.println( "\n"); 
    }
   
    //this method returns the total of the balances
    public static void total(Account b[]) { 
        //intialise total to zero
       double total = 0;
       //iterates through the balance arrays, adding every entry together to get a total
        for (int i = 0; i < 5; i++) { 
            total = total + b[i].getBalance();
        } 
        System.out.println( "The total of all the balances is: " + total);
    } 

}



  