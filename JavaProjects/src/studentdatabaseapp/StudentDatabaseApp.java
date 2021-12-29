package studentdatabaseapp;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
//		Student st = new Student();
		
		// Ask how many students to add
		System.out.println("How many students do you wish to add? \n");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
//		in.close();
		
		// Create n number of students
		Student.addStudents(num);
		
		// Call show student (specific student) ?
		
		// Call show all students
		Student.listStudents();
//		Student.listCourses();
		
   
    }

}
