package hw3;

import java.time.LocalDate;

public class Account {
	// Instance variables
	int id;
	double balance;
	LocalDate dateCreated;
	double annualInterestRate;
	// no-arg constructor
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.dateCreated = LocalDate.now();
		this.annualInterestRate = 0;
	}
	// arg constructor
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated = LocalDate.now();
		this.annualInterestRate = 0;
	}
	
	// id getter
	public int getId() {
		return id;
	}
	// id setter
	public void setId(int newId) {
		this.id = newId;
	}
	// balance getter
	public double getBalance() {
		return balance;
	}
	// balance setter
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	// annualInterestRate getter
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	// annualInterestRate setter
	public void setAnnualInterestRate(double newRate) {
		this.annualInterestRate = newRate;
	}
	// dateCreated getter
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	// get monthly interest
	public double getMonthlyInterest() {
		return balance*annualInterestRate/12;
	}
	// withdraw
	public void withdraw(double amt) {
		this.balance -= amt;
	}
	// deposit
	public void deposit(double amt) {
		this.balance += amt;
	}
	// id, balance, dateCreated toString 
	public String toString() {
		return String.format("%d, %.2f, %tD", id, balance, dateCreated);
	}
	// test
	public static void main(String[] args) {
		Account test1 = new Account(101, 20000);
		test1.setAnnualInterestRate(0.045);
		test1.withdraw(2500);
		test1.deposit(3000);
		System.out.format("Balance = %.2f\n", test1.getBalance());
		System.out.format("Monthly interest = %.2f\n", test1.getMonthlyInterest());
		System.out.format("Date created = %tD\n", test1.getDateCreated());
	}
	
}
