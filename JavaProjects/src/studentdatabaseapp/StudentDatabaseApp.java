package studentdatabaseapp;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		// Ask how many students to add
		System.out.println("How many students do you wish to add? \n");
		Scanner in = new Scanner(System.in);
		int numOfStudents = in.nextInt();
//		in.close();
		
		ArrayList<Student> allStudents = new ArrayList<Student>();
		
		for (int i=0; i<numOfStudents; i++) {
			Student stu = new Student();
			stu.enroll();
			stu.payTuition();
//			System.out.println(stu.toString());
			allStudents.add(stu);
		}
	
		// Call show all students
		listStudents(allStudents);
  
    }

	// Method: Show all students enrolled
	public static void listStudents(ArrayList<Student> students) {
        
        for (Student student : students) {
        	System.out.println(student);
        }
	}

}


// Call show student (specific student) ?
