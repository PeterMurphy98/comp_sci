package test1;

import java.util.Scanner;
import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		// Read numbers into array
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 integers: ");
		double[] nums = new double[10];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		// Find largest number in array
		double largest = 0;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] > largest) {
				largest = nums[i];
			}
		}
		// Normalise array
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i]/largest;
		}
		//Print array
		System.out.println(Arrays.toString(nums));
		input.close();
	}
	
}
