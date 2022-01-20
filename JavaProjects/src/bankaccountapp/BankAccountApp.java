package bankaccountapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BankAccountApp {

	public static void main(String[] args) {
		
		Checking chk1 = new Checking("Tom Wilson", "294132671", 1500);
		
		Savings save1 = new Savings("Rich Lowe", "897563462", 2500);
		
		save1.showInfo();
		chk1.showInfo();
		// Read a CSV file then create new accounts based on that data
		
		
	}
	

}
