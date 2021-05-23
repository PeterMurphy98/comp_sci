package test2;

public class Employee extends Person {
	private double salary;
	
	public Employee() {
		salary = 12345.0;
	}
	
	public Employee(String name, int age, String email, double salary) {
		super(name, age, email);
		this.setSalary(salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary < 0) {
			System.out.println("Error: Salary must be non-negative.");
		}
		else {
			this.salary = salary;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + salary + "\n";
	}
}
