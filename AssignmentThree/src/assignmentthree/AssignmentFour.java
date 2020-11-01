/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

/*Name: Mikaeli Bain
  Assignment Three
  13th November 2019
*/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AssignmentFour {

        public static void main(String[] args) {
             Scanner keyboard = new Scanner(System.in);
             Account[] singleAcc = new Account[5];
             //Create a bank object
             Bank yourBank = new Bank();
             System.out.println("Welcome to the Brooklyn College CISC 3115 Bank!");
             String aname;
             double bal;
             for (int i = 0; i < singleAcc.length; i++){
                 System.out.println("To start, please enter your name.");
                //Saves the input to a variable
                aname = keyboard.next();
                //the variable is then saved to the array
                System.out.println(aname + ", please enter an amount: ");
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
           //add accounts to the bank
           yourBank.addAccount(aname, bal);
                                 } 
            System.out.println("User, to check the balance on your account, please enter your name.");
            //reads the user input
                String fn = keyboard.next();
                boolean check = true;
                //if the user inputs a name that is in the array, then output the user's bank info
                while(check) {
                    try {
                    if(!yourBank.find(fn).equals(null)){
                        //prompt the user to withdraw money
                        System.out.println("Your current balance is " + yourBank.find(fn).getBalance() + " How much would you like to withdraw?");
                        //read the amount the user would like to withdraw
                            double amtWd = yourBank.find(fn).withdrawal(keyboard.nextDouble());
                            //display the user's blance after withdrawal
                            if (amtWd > 0 || amtWd == 0) {
                                System.out.println("\n" + "Your balance is " + amtWd);
                                 //call getAccounts and getNum
                                yourBank.getAccounts();
                                yourBank.getNum();
                                //use the toString method to display all the information of all the accounts in the bank
                                System.out.println(yourBank.toString());
                                //If the amount that will be withdrawn is equal to or less than the balance, the loop will end
                                check = false;
                            } else {
                                // if the amount that will be withdrawn exceeds the amount of the balance, the loop will repeat until an amount that is less than or equal to the blance is entered
                                 System.out.println("The money you wished to withdraw exceeds the money in your account. Please try again." + "\n" + "If you do not wish to withdraw money today, please enter 'no'. If you wish to continue, enter 'yes'");
                                 String ans = keyboard.next();
                                    if (ans.equals("yes")) {
                                        check = true;
                                    }else if (ans.equals("no")) {
                                        check = false;
                                    } else {
                                        check = true;
                                    }
                            }

                     
                     } 
                    } catch (NullPointerException e) {
                        System.out.println("There is no account in this bank by that name. Please ensure that you have entered the name correctly and try again" + "\n");
                        check = false;
                    }
        }
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
         public double withdrawal(double amt) { 
             //if the amount is greater than the balance in the account, proceed with transaction
             if (amt < balance || amt == 0) {
                 balance = balance - amt;
                return balance;
             } else if (amt > balance) {
                return -1;
         } else {
             return balance;
             }
             
         }
   }

   
 public static class Bank  {
     //the bank class should contain 2 private member variables. An array acct of Account objects, and n, the number of Accounts in the array
    private Account[] acct; 
    private int n;
    //constructor to initialise
        public Bank() {
            n = 0;
            acct = new Account[5];
        }
        //method to add accounts to the bank object
    void addAccount(String nm, double bal) {
        acct[n] = new Account(nm, bal);
        n++;
    }
    
   //method that uses a search algorithm to find a specific account in the Bank using a person's name
    public Account find(String nm) {
        //use a for loop to go through the entire array until the account is found. Then return the account
    for (int i= 0; i<n; i++) {
        if (acct[i].getAcctname().equals(nm)) 
        return acct[i];
    }
        return null;
    }
    //methos that retrives all the accounts in the bank
    public Account[] getAccounts() {
        return acct;
    }
   //method that saves all the account numbers(positions) in an array and returns the array
    public int[] getNum() {
        int[] numbers = new int[n];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = i;
   }
        return numbers;
    }
    //
   @Override
    public String toString() { 
                System.out.println( "\n"); 
        for (int i = 0; i < 5; i++) { 
            //gets the values of each of the arrays by pulling the values of the indexes we are accessing and prints out the values
              System.out.println("Account Name: " + getAccounts()[i].getAcctname() + " Account Balance: " + getAccounts()[i].getBalance() + " " + "Account Number " + getNum()[i]);
        } 
        System.out.println( "\n"); 
        return null;
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
    
    //this method iterates through an array and prints the contents of the array
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
