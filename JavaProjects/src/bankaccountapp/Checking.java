package bankaccountapp;

public class Checking extends Account {
	// List properties specific to checking account:
	
	private int debitCardNum;  // Debit Card number (12 digits)
	private int debitCardPin;  // 4-digit PIN
	
	// Constructor to initialize checking account properties
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "2" + accountNumber;
//		System.out.println("New Checking account");
//		System.out.println("Acc no: " + accountNumber);

	}
	// List any methods specific to Checking account
}
