package studentdatabaseapp;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Student {
	
	private String name;
	private int gradeYear;
	private String studentID;
	private HashSet<String> courses = new HashSet<>();
	private int tuitionBalance;
	private static int costOfCourse = 600;
	private static int id = 1000;
//	private static ArrayList<Student> students = new ArrayList<Student>();
	private static TreeMap<Integer, String> availableCourses = new TreeMap<>() {{ 
		put(1, "History 101");
		put(2, "Mathematics 101");
		put(3, "English 101");
		put(4, "Chemistry 101");
		put(5, "Computer Science 101");
	}};
		
	// Constructor to get name and year of student as inputs
	public Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter student name: ");
		this.name = in.nextLine();
		
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\n\nEnter student grade level: ");
		int year;
		do {
			year = in.nextInt();
			if (0 < year && year < 5) {
				this.gradeYear = year;
			} else {
				System.out.println("Invalid selection. Please choose a year between 1 and 4.");
			}
			
		} while (year > 4 || year < 1);
		
//		in.close();
		this.studentID = generateStudentID();
		
//		enroll();
//		payTuition();
//		showStatus();  --> changed to print toString()
		
	}
	
	// Generate a 5-digit unique ID, beginning with their grade level
	private String generateStudentID() {
//		return id + gradeYear * 10000;  --> Another way to generate the Student ID
		id++;
		return gradeYear + "" + id;
	}
	
	// Method: Enroll in courses
	public void enroll() {
		
		// Get inside a loop, user hits 0 when they're done enrolling
		listCourses();
		int selection;
		
		do {
			Scanner in = new Scanner(System.in);
			System.out.print("\nEnter course code to enroll (0 to quit): ");
			selection = in.nextInt();
			
			if (0 < selection && selection < 6) {
				String courseName = availableCourses.get(selection);
				courses.add(courseName);
				System.out.println("Successfully enrolled in: " + courseName);				
			} else if( selection != 0 ) {
				System.out.println("Invalid selection. Please choose a number between 1 and 5.");
			}

		} while (selection != 0);
		
		tuitionBalance = courses.size() * costOfCourse;
		System.out.println(name + " is enrolled in the following courses:\n");	
		for (String course : courses) {
			System.out.println(course);
		}
	}
	
	// Method: show balance and pay tuition
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	public void payTuition() {	
		viewBalance();
		System.out.print("\nPlease enter the amount you wish to pay now: ");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		if (tuitionBalance < 0) { tuitionBalance = 0; }
		System.out.println("Thank you for the payment of $" + payment);
		viewBalance();
		if (tuitionBalance == 0) {
			System.out.println("Your tuition is now fully paid up!");
		}
	}
	
	public static void listCourses() {
        
        for (Map.Entry<Integer, String> course : availableCourses.entrySet()) {
        	System.out.println(course.getKey() + ": " + course.getValue());
        }
	}

	// Method: Show status of student
	@Override
	public String toString() {
		return "\n\nNAME: " + this.name +
				"\nSTUDENT ID: " + this.studentID + 
				"\nCOURSES ENROLLED: " + this.courses +
				"\nTUITION BALANCE: " + this.tuitionBalance;
	}

}
