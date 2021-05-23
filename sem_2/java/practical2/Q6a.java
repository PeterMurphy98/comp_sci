// Q6 solution using a switch statement

package practical2;

import java.util.Scanner;

public class Q6a {
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a year
		System.out.println("Enter a year:");
		int year = input.nextInt();

		// Display the animal for the year
		switch (year % 12) {
		case 0: System.out.println("Monkey"); break;
		case 1: System.out.println("Rooster"); break;
		case 2: System.out.println("Dog"); break;
		case 3: System.out.println("Pig"); break;
		case 4: System.out.println("Rat"); break;
		case 5: System.out.println("Ox"); break;
		case 6: System.out.println("Tiger"); break;
		case 7: System.out.println("Rabbit"); break;
		case 8: System.out.println("Dragon"); break;
		case 9: System.out.println("Snake"); break;
		case 10: System.out.println("Horse"); break;
		case 11: System.out.println("Sheep"); break;
		}
		
		// Close the Scanner
		input.close();
	}
}
