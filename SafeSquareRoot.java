import java.util.*;
public class SafeSquareRoot {
	public static void main ( String[] args ) {
		Scanner key = new Scanner(System.in);
		double n1 = 0;
		double squareRt = 0;

		System.out.println("SQUARE ROOT");
		System.out.print("Enter a number: ");	
		n1 = key.nextInt();

		while (n1 < 0) {	
			System.out.println("You can't take the square root of a negative number, silly.");
			System.out.print("Try again:");
			n1 = key.nextInt();
			squareRt = Math.sqrt(n1);
		} 
		
		System.out.println("The square root of " + n1 + " is " + squareRt + ".");
	
	}
}