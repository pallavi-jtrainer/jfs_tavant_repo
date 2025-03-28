package mainpkg;

import java.util.ArrayList;
import java.util.Scanner;

import models.Course;
import models.Student;

public class MainClass {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		
		courses.add(new Course(101, "Core Java"));
		courses.add(new Course(102, "Spring Boot"));
		courses.add(new Course(103, "MongoDB"));
		
		MainClass obj = new MainClass();
		obj.mainMenu(students, courses);
		
	}

	private void mainMenu(ArrayList<Student> students, ArrayList<Course> courses) {
		int ch = 1;
		do {
			System.out.println("1. Student Menu");
			System.out.println("2. Courses Menu");
			System.out.println("3. Exit");
			System.out.println("Your choice?");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				studentMenu(students, courses);
				break;
			case 2:
				//courseMenu();
				break;
			default:
				Runtime.getRuntime().exit(0);
			}
		} while(ch > 0 && ch < 4);
	}
	
	private void studentMenu(ArrayList<Student> students, ArrayList<Course> courses) {
		System.out.println("1. add student \n2. Delete Student\n"
				+ "3. View Student Details\n4. View All Students\n" 
				+ "5. Update Student\n6. Exit");
		System.out.println("You choice?");
		int ch1 = sc.nextInt();
		
		switch(ch1) {
		case 1:
			System.out.println("Id: ");
			int id = sc.nextInt();
			System.out.println("First Name");
			String fname = sc.next();
			System.out.println("Last Name:");
			String lname = sc.next();
			System.out.println("Age: ");
			int age = sc.nextInt();
			
			Student s = new Student(id, fname, lname, age, courses.get(0));
			students.add(s);
			break;
		case 4:
			for(int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			break;
		}
	}
}
