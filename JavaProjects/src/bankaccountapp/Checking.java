package bankaccountapp;

public class Checking extends Account {
	// Properties specific to checking account:
	
	private String debitCardNum;  // Debit Card number (12 digits)
	private String debitCardPin;  // 4-digit PIN
	
	// Constructor to initialize checking account properties
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "2" + accountNumber;
		createDebitCard();
	}
	
	// Methods specific to Checking account:
	
	// Polymorphism -> this method is overriding the inherited one
	public void showInfo() {
		System.out.println("Account Type: Checking");
		super.showInfo();
		System.out.println("Debit Card Number: " + debitCardNum +
				"\nDebit Card Pin: " + debitCardPin);
	}
	
	public void createDebitCard() {
		debitCardNum = longRandomNumbers(12);
		debitCardPin = super.randomNumbers(4);
	}
	
    public String longRandomNumbers(int numOfDigits)
	{
		long number = (long)(Math.random() * Math.pow(10, numOfDigits));
		String digits = Long.toString(number);
		while(digits.length() != numOfDigits)
		{
			digits = "0" + digits;
		}
		return digits;
	}
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}
}
