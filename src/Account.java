import java.util.Scanner;

public class Account {
//	class variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
//	class constructor
	Account(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	
//	Function for depositing money
	void deposit (int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
//	Function for withdrawing money
	void withdraw (int amount) {
		if (amount != 0) {
			balance = balance - amount; 
			previousTransaction = -amount;
		}
	}
	
//	Function showing previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occurred");
		}
	}
	
//	Function calculating interest of current funds after a number of years
	void calculateInterest (int years) {
		double interestRate = 0.0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
//	Function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transactions");
		System.out.println("E. Calculate interest");
		System.out.println("D. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scnr.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch (option) {
			case 'A': 
//				Case 'A' allows the user to check their account balance
				System.out.println("=====================================");
				System.out.println("Balance = $" + balance);
				System.out.println("=====================================");
				System.out.println();
				break;
			case 'B': 
//				Case 'B' allows the user to make a deposit
				System.out.println("Enter an amount to deposit: ");
				int amount = scnr.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
//				Case 'C' allows the user to withdraw money from their account
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scnr.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
//				Case 'D' allows the user to view their most recent transaction
				System.out.println("=====================================");
				getPreviousTransaction();
				System.out.println("=====================================");
				System.out.println();
				break;
			case 'E':
//				Case 'E' calculates the accrued interest on the account after a number of years
				System.out.println("How many years of accrued interest? ");
				int years = scnr.nextInt();
				calculateInterest(years);
				break;
			case 'F':
//				Case 'F' allows the user to exit the application
				System.out.println("=====================================");
				break;
			default: 
				System.out.println("Error: invalid option. Please enter either A, B, C, D, E, or F.");
			}
		} while (option != 'F');
		
		System.out.println("Thank you for banking with us!");
	}
}
