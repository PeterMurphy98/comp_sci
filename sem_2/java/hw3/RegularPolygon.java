package hw3;

import java.lang.Math;

public class RegularPolygon {
	// Instance variables
	int n;
	double length;
	// no arg constructor 
	public RegularPolygon() {
		this.n = 3;
		this.length = 1;
	}
	// arg constructor
	public RegularPolygon(int n, double length) {
		this.n = n;
		this.length = length;
	}
	// n getter
	public int getN() {
		return n;
	}
	// n setter
	public void setN(int newN) {
		if (newN < 0) {
			System.out.println("Error: Number must be positive.");
		}
		else {
			this.n = newN;
		}
	}
	// length getter
	public double getLength() {
		return length;
	}
	// length setter
	public void setLength(double newLength) {
		if (newLength < 0) {
			System.out.println("Error: Number must be positive.");
		}
		else {
			this.length = newLength;
		}
	}
	// get perimeter
	public double getPerimeter() {
		return n*length;
	}
	// get area
	public double getArea() {
		return n*length*length/(4*Math.tan(Math.PI/n));
	}
	// n, length toString
	public String toString() {
		return String.format("%d, %.2f", n, length);
	}
	// test
	public static void main(String[] args) {
		// array of RegularPolygons
		RegularPolygon arr[] = new RegularPolygon[4];
		arr[0] = new RegularPolygon(3, 10.0);
		arr[1] = new RegularPolygon(6, 7.5);
		arr[2] = new RegularPolygon(8, 3.5);
		arr[3] = new RegularPolygon(12, 4.0);
		// Variables to record smallest perimeter, largest area
		double small_per = arr[0].getPerimeter();
		int small_per_ind = 0;
		double large_area = arr[0].getArea();
		int large_area_ind = 0;
		// loop through array
		for (int i = 0; i < arr.length; i++) {
			// update smallest perimeter
			if (arr[i].getPerimeter() < small_per) {
				small_per_ind = i;
			}
			// update largest area
			if (arr[i].getArea() > large_area) {
				large_area_ind = i;
			}
			// print string, perimeter and area
			System.out.format("String representaation: (%s), Perimeter = %.2f, Area = %.2f \n", 
								arr[i].toString(), arr[i].getPerimeter(), arr[i].getArea() );
		}
		// print smallest perimeter and largest area strings
		System.out.format("Smallest perimeter: %s \n", arr[small_per_ind].toString());
		System.out.format("Largest area: %s \n", arr[large_area_ind].toString());
		
	}
}
