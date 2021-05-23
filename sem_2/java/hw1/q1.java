package ass1;

import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		// Read speed, acceleration, weather
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the speed: ");
		double v = input.nextDouble();
		System.out.print("Enter the acceleration: ");
		double a = input.nextDouble();		
		System.out.print("Enter the weather conditions ('d' for dry, 'w' for wet): ");
		char weather = input.next().charAt(0);
		// If wet, set weather multiplier to 1.15
		double w = 1;
		if (weather == 'd' || weather == 'D') {
		}
		else if (weather =='w' || weather == 'W') {
			w = 1.15;
		}
		else {
			System.out.println("Input is invalid. Enter 'd' for dry, 'w' for wet.");
			System.exit(1);
		}
		// Calculate length
		double length = w*v*v/(2*a);
		System.out.println("Length: " + length);
		// Close the Scanner
		input.close();
	}

}
