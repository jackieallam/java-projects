package bankaccountapp;

public class Savings extends Account {
	// List properties specific to Savings account:
	
	private int depositBoxNum;  // Safety Deposit Box (3-digit number)
	private int accessCode;  // 4-digit access code
	
	// Constructor to initialize Savings account properties
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "1" + accountNumber;
//		System.out.println("New Savings account");
//		System.out.println("Acc no: " + accountNumber);

	}
	// List any methods specific to Savings account
	
//	public void showInfo() {
//	}
}
