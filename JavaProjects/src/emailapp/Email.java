package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxSize = 500;
	private int defaultPasswordLength = 10;
	private String altEmail;
	private String companySuffix = "company.com";
	
	// Constructor to receive first and last name
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("NAME SET: " + this.firstName + " " + this.lastName);
		
		// Call method asking for department -> return the dept
		this.department = setDepartment();
//		System.out.println("DEPARTMENT: " + this.department);
		
		// Call method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		String emailSuffix = department == "" ? companySuffix : "." + companySuffix; 
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + emailSuffix;
//		System.out.println(email);
		
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.println("New worker: " + firstName + " " + lastName + 
				"\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:\n");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) { return "sales"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "accounting"; }
		else { return ""; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			// Math.random() generates number between 0 and 1
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
//		return String.valueOf(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxSize(int capacity) {
		this.mailboxSize = capacity;
	}
	
	// Set an alternate email
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String newPass) {
		this.password = newPass;
	}
	
	// Get name, email and capacity
	public String getName() { return firstName + " " + lastName; }
	public String getEmail() { return email; }
	public String getAltEmail() { return altEmail; }
	public int getMailboxSize() { return mailboxSize; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX SIZE: " + mailboxSize + "MB";
	}

	@Override
	public String toString() {
		return "Email [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mailboxSize="
				+ mailboxSize + "]";
	}
	
}
