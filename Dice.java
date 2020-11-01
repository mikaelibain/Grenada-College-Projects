import java.util.*;
public class Dice {
	public static void main ( String[] args ){
		Random rand = new Random();
		int n1, n2, total;
		
		System.out.println("HERE COMES THE DICE!");
	
		do {
		        n1 = 1 + rand.nextInt(6);
			n2 = 1 + rand.nextInt(6);

   			System.out.println("Roll #1: " + n1 );
			System.out.println("Roll #2: " + n2 );
			total = n1 + n2;
			System.out.println("The total is " + total + "!");
		} while ( n1 != n2 );
	}
}