
package assignment6;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;



/*Name: Mikaeli Bain
  Assignment Six
  9th December 2019
*/

public class AssignmentSix {
private static final String quit = "exit";


public static void main(final String[] args) {
    Hashtable<String, Integer> phonebook = new Hashtable<String, Integer>();
    Scanner keyboard = new Scanner(System.in);
    boolean repeat = true;
    boolean t = true;
    //welcome statement
    System.out.println("Welcome to Mikaeli Bain's phonebook. To begin, please input the amount of entries you would like to make in this phonebook." );
    //saves the number of phoneboook entries
    while (t) {
        try {
        int num_entries = keyboard.nextInt();
        //loop will prompt the user to make entries until all entries are made or until the user wishes to quit
            while (num_entries > 0) {
                System.out.println("\n"+ "Please enter the name of your entry."+ " If you would like to stop making entries, please enter 'exit'.");
                String name = keyboard.next();
                if (quit.equalsIgnoreCase(name)) {
                    break;
                }
                do {
                    try {
                        System.out.println("Please enter the 9 digit number of your entry." );
                        int number = keyboard.nextInt();
                        
                            if(checkDigit(number) >  9 || checkDigit(number) < 9) {
                                System.out.println("That is not a 9 digit number");
                                repeat = true;
                            }
                            else {
                                phonebook.put(name, number);
                                --num_entries;       
                                repeat = false;
                            }
                    }catch(InputMismatchException e) {
                          System.out.println("That was not a number. Please try again");
                          keyboard.next(); 
                          repeat = true;
                    }
                }while(repeat);

            }
            t = false;
                    System.out.println("Mikaeli's phone has the following entries " + phonebook);
                    boolean query_loop = true;
                    while (query_loop) {
                        System.out.println("Would you like to search for anyone's phone number? If so, enter 'yes', if not, enter 'no'." + "\n");
                        String y = keyboard.next();
                             if(y.equalsIgnoreCase("yes")) {
                                System.out.println("Please enter the name of the person whose number you want to find.");
                                String query = keyboard.next();
                                boolean test = true;
                                    while(test) {
                                        try{
                                            Integer query_num = phonebook.get(query);
                                            if(query_num == null) {
                                                 System.out.println("Sorry, but this number is unlisted."+ "\n");
                                                 test = false;
                                            } else if (!(query_num == null)) {
                                                System.out.println(query + "'s number is " + query_num);
                                                test = false;
                                            }
                                        }catch(InputMismatchException e){
                                            System.out.println("Sorry, but this person does not exist in our phonebook, Please check your spelling and capitalisation and  try again");
                                            keyboard.next();   // or scanner.nextLine()
                                            test = true;
                                        }
                                    }
                                    
                            }else if (y.equalsIgnoreCase("no")){
                                 System.out.println("Thank you for using Mikaeli's phonebook. Mikaeli's phonebook has the following entries " +"\n"+ phonebook); 
                                 query_loop = false;
                            }else {
                                 System.out.println("You did not enter any available option, so here is Mikaeli's phonebook" +"\n" + phonebook); 
                            }
                    }
            } catch (InputMismatchException e) {
                    System.out.println("That was not a number. Please try again" +"\n");
                    keyboard.next(); 
                    t = true;
            }    
 
        }
    } 
 
    static int checkDigit(int n) { 
     int count = 0;
    
       do {
	n = n/10;
        count = count + 1; 
	} while (n > 0);
		return count;
    }   
}
