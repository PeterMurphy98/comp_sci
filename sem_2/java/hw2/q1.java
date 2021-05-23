package hw2;

import java.util.Scanner;

public class q1 {
	// Returns futureValue for entered amount, rate, years
	public static double futureValue(double amount, double monthlyRate, int years) {
		double fV = amount * Math.pow(1+monthlyRate, years*12);
		return fV;
	}
	
	public static void main(String[] args) {
		// Read amount, yearly rate
		Scanner input = new Scanner(System.in);
		System.out.print("The amount invested: ");
		double amt = input.nextDouble();
		while (amt < 0) {
			System.out.println("Invalid amount. Enter a positive number: ");
			amt = input.nextDouble();
		}
		System.out.print("Annual interest rate: ");
		double rate = input.nextDouble();
		// Print years-value table
		System.out.println("Years   Value");
		for (int i = 0; i < 30; i++) {
			System.out.format("%-7d %.2f \n", i+1, futureValue(amt, rate/1200, i+1));
		}
		input.close();
	}
}