package bankaccountapp;

public class Savings extends Account {
	// List properties specific to Savings account:
	
	private static int boxIndex = 0;
	private int depositBoxNum;  // Safety Deposit Box (3-digit number)
	private String accessCode;  // 4-digit access code
		
	// Constructor to initialize Savings account properties
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "1" + accountNumber;
		createDepositBox();
	}

	// Methods specific to Savings account:
	
	// Polymorphism -> this method is overriding the inherited one
	public void showInfo() {
		System.out.println("Account Type: Savings");
		super.showInfo();
		System.out.println("Deposit Box: " + depositBoxNum +
				"\nAccess Code: " + accessCode);
	}
	
	private void createDepositBox() {
		boxIndex++;
		this.depositBoxNum = boxIndex;
		accessCode = super.randomNumbers(4);
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
}
