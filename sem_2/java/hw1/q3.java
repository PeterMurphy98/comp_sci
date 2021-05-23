package ass1;

import java.util.Scanner;
import java.util.Random;

public class q3 {
	public static void main(String[] args) {
		// Generate random number
		Random rand = new Random();
		int n = rand.nextInt(101);
		
		// Read the guess
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 100: ");
		int g = input.nextInt();
		
		// Read new guess until correct guess
		while (g != n) {
			if (g < 0 || g > 100){
				System.out.print("Invalid guess. Enter a number between 0 and 100.");
			}
			else {
				if (g > n) {
					System.out.println("Too high.");
					System.out.print("Enter a number: ");
					g = input.nextInt();
				}
				else {
					System.out.println("Too low.");
					System.out.print("Enter a number: ");
					g = input.nextInt();	
				}
			}
		}
		System.out.print("Correct!");			
		
		// Close the Scanner
		input.close();
	}

}
