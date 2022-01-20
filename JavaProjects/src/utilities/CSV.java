package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {
	
	// This method will read data from a CSV file and return as a list
	
	public static ArrayList<String[]> read(String filename) {
		
		File file = new File(filename);
		ArrayList<String[]> lines = new ArrayList<String[]>();
		String line;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			
			while ((line = br.readLine()) != null) {
				lines.add(line.split(","));
			}
						
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (IOException e) {
			System.out.println("Problem reading the file " + file.getName());
		} 
		return lines;
	}
}
