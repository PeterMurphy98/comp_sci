package ass1;

import java.util.Scanner;

public class q2 {
	public static void main(String[] args) {
		// Read year, month
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int y = input.nextInt();
		System.out.print("Enter the month: ");
		int m = input.nextInt();		
		// Check month and year are valid
		if ((m > 0 && m < 13) && y > 0) {
			if (m == 4 || m == 6 || m == 9 || m == 11) {
				System.out.print("Days in month: " + 30);
			}
			else if (m == 2) {
				if (y % 4 == 0) {
					System.out.print("Days in month: " + 29);
				}
				else {
					System.out.print("Days in month: " + 28);
				}
			}
			else {
				System.out.print("Days in month: " + 31);
			}
		}
		else {
			System.out.println("Input is invalid. Enter a number for year and month.");
			System.exit(1);
		}
		// Close the Scanner
		input.close();
	}

}
