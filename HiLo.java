import java.util.*;
public class HiLo {
	public static void main ( String[] args ) {
		Scanner key = new Scanner (System.in);
		Random r = new Random();
		int i = 1 + r.nextInt(10);
		int guess = 0;
		int guessNum = 2;
		int guessCount = 0;

		System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
		System.out.println("First guess: ");
		guess = key.nextInt();
		guessCount++;

		while( guess != i && guessCount < 7 ) {
			if (guess < i ) {
				System.out.println("Sorry, you are too low.");
			} else if (guess > i ) {
				System.out.println("Sorry, you are too high.");

			}
			System.out.println("Guess # " + guessNum + ": ");
			guess = key.nextInt();
			guessNum++;
			guessCount++;
		}
		
		if (guess == i) {
			System.out.println("You guessed it!  What are the odds?!?");
		} else {
		System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
		}
	}
}