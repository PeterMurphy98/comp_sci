package hw2;

import java.util.Scanner;

public class q2 {
	// Check password length is at least 2
	public static boolean twoCharacters(String pw){
		if (pw.length() > 1) {
			return true;
		}
		else {
			return false;
		}
	}
	// Check password contains only letters and digits
	public static boolean onlyLettersDigits(String pw){
		for (int i = 0; i < pw.length(); i++) {
			if (Character.isDigit(pw.charAt(i)) || Character.isLetter(pw.charAt(i))) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	// Check password contains at least 3 digits
	public static boolean threeDigits(String pw){
		int d_count = 0;
		for (int i = 0; i < pw.length(); i++) {
			if (Character.isDigit(pw.charAt(i))) {
				d_count += 1;
			}
		}
		if (d_count > 2) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// Read password
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Password: ");
		String pw = input.nextLine();
		// Check conditions
		if (twoCharacters(pw) && onlyLettersDigits(pw) && threeDigits(pw)) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Invalid Password");

		}
		input.close();
	}
}