import java.util.*;
public class NumberGuess {
	public static void main ( String[] args ) {
		Scanner key = new Scanner(System.in);
		
		Random r = new Random();
		int i = 1 + r.nextInt(10);
		int tries = 0;
		int guess = 0;

		System.out.println("I have chosen a number between 1 and 10.  Try to guess it.");

		while (guess != i) {	
			System.out.println("Your guess: ");	
			guess = key.nextInt();
			tries++;
			System.out.println("That is incorrect.  Guess again.");
		}
		
		System.out.println("That's right!  You're a good guesser.");
		System.out.println("It only took you " + tries + " tries.");
	}
}


  		