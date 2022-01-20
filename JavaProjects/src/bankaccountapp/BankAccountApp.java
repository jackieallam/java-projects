package bankaccountapp;

import java.util.ArrayList;

import utilities.CSV;

public class BankAccountApp {

	public static void main(String[] args) {

		// Read a CSV file then create new accounts based on that data
		ArrayList<String[]> newAccounts = CSV.read("NewBankAccounts.csv");
		ArrayList<Account> allAccounts = new ArrayList<Account>();
		
		for (String[] line: newAccounts) {
			String name = line[0];
			String ssn = line[1];
			String accountType = line[2];
			double initDeposit = Double.valueOf(line[3]);

			if (accountType.equals("Savings")) {
			
				allAccounts.add(new Savings(name, ssn, initDeposit));
			} 
			else if (accountType.equals("Checking")) {
			
				allAccounts.add(new Checking(name, ssn, initDeposit));
			} else {
				System.out.println("Error reading Account type.");
			}
			
		}
		
		for (Account individualAccount : allAccounts) {
			
			individualAccount.showInfo();
			System.out.println("-------------------------------");
		}
		
		// Testing stuff
//		Checking chk1 = new Checking("Tom Wilson", "294132671", 1500);
//		Savings save1 = new Savings("Rich Lowe", "897563462", 2500);
//		
//		save1.showInfo();
//		System.out.println("*************");
//		chk1.showInfo();
//		
//		System.out.println("*************");
//		save1.deposit(5000);
//		save1.withdraw(200);
//		save1.transfer("Brokerage", 3000);
//		save1.compound();
		
//		System.out.println(save1.accountNumber);
	}


}
