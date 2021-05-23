package test1;

import java.util.Scanner;
import java.util.Random;

public class Q2 {
	// Method to return random char in a string
	public static char randomChar(String str) {
		// Generate random number between 0 and 100
		Random rand = new Random();
		int rand_int = rand.nextInt(100);
		// Use modulo to reduce the number to a valid index
		int i = rand_int%(str.length());
		return str.charAt(i);
	}
	
	public static void main(String[] args) {
		// Read string
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = input.nextLine();
		// Call method on string
		System.out.println(randomChar(str));
		input.close();
	}
	
}