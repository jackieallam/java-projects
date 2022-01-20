package bankaccountapp;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String clientName;
	private String clientSSN;
	private double balance;

	protected String accountNumber;
	protected double rate;
	private static int unique5Digits = 10000;

	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double depositAmt) {
		this.clientName = name;
		this.clientSSN = ssn;
		this.balance = depositAmt;
		
		// Set account number
		this.accountNumber = setAccountNumber();
		
		setRate();
	}

	private String setAccountNumber() {
		// Last 2 digits of SSN
		String last2SSN = clientSSN.substring(clientSSN.length() - 2);
		// Unique 5-digit number
		unique5Digits++;
		// Random 3-digit number
		String random3Digits = randomNumbers(3);
		return last2SSN + unique5Digits + random3Digits;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accruied Interest $" + accruedInterest);
		printBalance();
	}

	// Common transaction methods:
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	 
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		this.balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void  printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}

	public void showInfo() {
		 System.out.println("Name: " + this.clientName + 
				 "\nAccount Number: " + accountNumber + 
				 "\nBalance: $" + balance +
				 "\nInterest Rate: " + rate + "%");
	}
	
	public abstract void setRate();
	
	public String randomNumbers(int numOfDigits) {
    		int number =  (int)(Math.random() * Math.pow(10, numOfDigits));
    		String digits = Integer.toString(number);
    		while(digits.length() != numOfDigits)
    		{ 	digits = "0" + digits;	}
    		return digits;
    } 
}
