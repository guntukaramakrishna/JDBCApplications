package com.jdbc.students;

import java.util.List;
import java.util.Scanner;

/**
 * Menu Driven application
 * @author PRODEP_SOL
 *
 */
public class StudentOperations {

	public static void main(String[] args) {

		int userChoice;
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		String choice = "";
		//StudentDAOOracle dao = new StudentDAOOracle();
		StudentDAOI dao = new StudentDAO();
		// StudentDAOOracle - 

		
		System.out.println("Welcome to Student Managament");

		do{
			System.out.println("1.Add a Student");
			System.out.println("2.Delete a Student");
			System.out.println("3.Update a Student");
			System.out.println("4.Get a Student");
			System.out.println("5.List all students");
			
			System.out.println("Choose what you want to do ??");
			
			userChoice = in.nextInt();

			switch (userChoice){
			case 1:
				System.out.println("Adding a student !!");
				Student s = new Student();
				s.setSid(4332);
				s.setCourse("Chemistry");
				s.setSname("Babu");

				try {
					boolean isAdded = dao.addStudent(s);
					if(isAdded) {
						System.out.println("Student Added succesfully");
					}
					else{
						System.out.println("Failed to add the student");
					}
				} catch (Exception e) {
					System.out.println("problem in adding the student");
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Delete an student - ");
				try {
					boolean isDeleted = dao.deleteStudent(4332);
					if(isDeleted){
						System.out.println("Deleted succesfully");
					}
					else{
						System.out.println("problem in deleting");
					}
				} catch (Exception e1) {
					System.out.println("problem in deleting the student");
					e1.printStackTrace();
				}
				break;

			case 4:
				System.out.println("---Listing one student--");
				try {
					Student ss= dao.findStudentById(1);
					if(ss != null){
						System.out.println(ss);
					}
					else{
						System.out.println("Not found !!");
					}
				} catch (Exception e) {
					System.out.println("problem in listing the student");
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("---Listing all students--");
				try {
					List<Student> students = dao.findAllStudents();
					for(Student ss: students){
						System.out.println(ss);
					}
				} catch (Exception e) {
					System.out.println("problem in listing the students");
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Wrong choice.");
				break;

			}
			
			System.out.println("Do you want to continue (Y/N)??");
			choice = in.next();
			
		}while(choice.equalsIgnoreCase("Y"));
		
		System.out.println("End");

	}
}
