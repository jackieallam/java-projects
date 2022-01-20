package bankaccountapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mine {

	public static void main(String[] args) {
		
		ArrayList<String> allAccounts = readNewAccountsFile();
		// Read a CSV file then create new accounts based on that data
		
		for (String account: allAccounts) {
			System.out.println(account);
		}
		
	}
	
	public static ArrayList<String> readNewAccountsFile() {
		File file = new File("NewBankAccounts.csv");
		ArrayList<String> accounts = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			
			String line = br.readLine();
			while (line != null) {
//				System.out.println(line);
				accounts.add(line);
				line = br.readLine();
			}
			return accounts;
						
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return accounts;
			
		} catch (IOException e) {
			System.out.println("Problem reading the file " + file.getName());
			return accounts;
		} 
	}


}
