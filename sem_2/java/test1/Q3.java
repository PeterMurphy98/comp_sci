package test1;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Q3 {
	// Method to return array and average of dice rolls
	public static void rollDice(int n) {
		Random rand = new Random();
		// Initialise array, avg
		int[] results = new int[n];
		double avg = 0;
		// Generate random dice rolls
		for (int i = 0; i<n; i++) {
			int dice1 = 1+rand.nextInt(6);
			int dice2 = 1+rand.nextInt(6);
			results[i] = dice1 + dice2;
			avg += Double.valueOf(results[i])/Double.valueOf(n);
		}
		// Print array, avg
		System.out.println(Arrays.toString(results));
		System.out.format("Average: %.2f", avg);
	}
	
	public static void main(String[] args) {
		// Read number of rolls
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of times: ");
		int n = input.nextInt();
		// Call method
		rollDice(n);
		input.close();
	}
	
}