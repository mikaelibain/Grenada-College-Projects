import java.util.*;
public class RightTriangle {
	public static void main ( String[] args ) {
		Scanner key = new Scanner(System.in);
		int s1, s2, s3;

		System.out.println("Enter three integers:");
		System.out.print("Side 1: ");	
		s1 = key.nextInt();
		System.out.print("Side 2: ");
		s2 = key.nextInt();

		while (s1 > s2) {	
			System.out.println(s1 + " is smaller than " + s2 + ".  Try again.");
			System.out.print("Side 2: ");
			s2 = key.nextInt();
		} 
		
		System.out.print("Side 3: ");
		s3 = key.nextInt();
		
		while (s2 > s3) {	
			System.out.println(s2 + " is smaller than " + s3 + ".  Try again.");
			System.out.print("Side 3: ");
			s3 = key.nextInt();
		} 
		System.out.println("Your three sides are "+ s1 + " " + s2 + " " + s3 );
		
		if ( (s3*s3) == (s1*s1) + (s2*s2) ) {
			System.out.println("These sides *do* make a right triangle.  Yippy-skippy!" );
		} else {
			System.out.println("NO!  These sides do not make a right triangle!" );
		}
	}
}