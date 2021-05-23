// Q6 solution using an if-else statement

package practical2;

import java.util.Scanner;

public class Q6b {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a year
		System.out.println("Enter a year:");
		int year = input.nextInt();

		// Display the animal for the year
		int rem = year % 12;
		
		if (rem == 0) 
			System.out.println("Monkey");
		else if (rem == 1) 
			System.out.println("Rooster");
		else if (rem == 2) 
			System.out.println("Dog");
		else if (rem == 3) 
			System.out.println("Pig");
		else if (rem == 4) 
			System.out.println("Rat");
		else if (rem == 5) 
			System.out.println("Ox");
		else if (rem == 6) 
			System.out.println("Tiger");
		else if (rem == 7) 
			System.out.println("Rabbit");
		else if (rem == 8) 
			System.out.println("Dragon");
		else if (rem == 9) 
			System.out.println("Snake");
		else if (rem == 10) 
			System.out.println("Horse");
		else 
			System.out.println("Sheep");

		// Close the Scanner
		input.close();
	}
}
