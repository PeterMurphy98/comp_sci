package ass1;

import java.util.Scanner;

public class q4 {
	public static void main(String[] args) {
		
		// Read the guess
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two strings: ");
		String str1 = input.nextLine();
		String str2 = input.nextLine();		

		int count = 0;
		String common = "";
		while ( (count < str1.length() && count < str2.length() ) && ( str1.charAt(count) == str2.charAt(count) ) ) {
			common += str1.charAt(count);
			count += 1;
		}
		if (common == "") {
			System.out.print("No common prefix");						
		}
		else {
			System.out.print(common);			
		}
		
		// Close the Scanner
		input.close();
	}

}
