package bankaccountapp;

import java.util.Random;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String clientName;
	private String clientSSN;
	private double balance;

	String accountNumber;
	private double rate;
	private static int unique5Digits = 10000;

	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double depositAmt) {
		this.clientName = name;
		this.clientSSN = ssn;
		this.balance = depositAmt;
		
//		System.out.println("Name: " + clientName + " SSN: " + clientSSN + " Balance: $" + balance);
		
		// Set account number
		this.accountNumber = setAccountNumber();
	}

	private String setAccountNumber() {
		// Last 2 digits of SSN
		String last2SSN = clientSSN.substring(clientSSN.length() - 2);
		// Unique 5-digit number
		unique5Digits++;
		// Random 3-digit number
		Random rand = new Random();
		String random3Digits = String.format("%03d", rand.nextInt(1000));
		return last2SSN + unique5Digits + random3Digits;
	}

	// List common methods:
	// deposit()
	// withdraw()
	// transfer()
	 public void showInfo() {
		 System.out.println("\nName: " + this.clientName + 
				 "\nAccount Number: " + accountNumber + 
				 "\nBalance: $" + balance);
		
	 }
}
