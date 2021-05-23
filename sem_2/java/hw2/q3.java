package hw2;

import java.util.Scanner;

public class q3 {
	// Check string contains only WDL
	public static boolean validString(String str){
		for (int i = 0; i < str.length(); i++) {
			if (str.toLowerCase().charAt(i) == 'w' || str.toLowerCase().charAt(i) == 'd' || str.toLowerCase().charAt(i) == 'l'){
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	// Calculate total points
	public static double totalPoints(String str) {
		double total = 0;
		// Add 3 points for 'w'
		for (int i = 0; i < str.length(); i++) {
			if (str.toLowerCase().charAt(i) == 'w'){
				total += 3;
			}
		}
		// Add 1 point for 'd'
		for (int i = 0; i < str.length(); i++) {
			if (str.toLowerCase().charAt(i) == 'd'){
				total += 1;
			}
		}
		return total;
	}
	public static double avgPoints(String str) {
		double avg = totalPoints(str)/(str.length());
		return avg;
	}
	
	public static void main(String[] args) {
		// Read string
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String str = input.nextLine();
		// Check conditions
		while (!validString(str)){
			System.out.println("Invalid format, enter again.");
			str = input.nextLine();
		}
		System.out.format("Total points: %.0f \nAverage points: %.2f", totalPoints(str), avgPoints(str));
		input.close();
	}
}