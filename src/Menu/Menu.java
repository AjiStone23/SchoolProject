/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import ManipulateData.Validator;
import ManipulateData.DisplayData;
import ManipulateData.ChooseAndAssign;
import ManipulateData.CreateDataFromUserInput;
import JavaConnectionWithSql.DBUtils;
import static ManipulateData.DeleteData.deleteAssignment;
import static ManipulateData.DeleteData.deleteClassroom;
import static ManipulateData.DeleteData.deleteCourse;
import static ManipulateData.DeleteData.deleteStream;
import static ManipulateData.DeleteData.deleteStudent;
import static ManipulateData.DeleteData.deleteTrainer;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajist
 */
public class Menu {

	public static void start() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Hi, Enter your user name of your database");
			
				String username= sc.nextLine();
				
		System.out.println("Enter the password of you database");		
				String password= sc.nextLine();
			DBUtils.setPass(password);
			DBUtils.setUsername(username);
				
       while (!DBUtils.createConnection()) {

			System.out.println("Invalid inputs!!!");
			System.out.println("Try again");
			System.out.println("\nEnter username");
			
			username = sc.nextLine();
			System.out.println("\nEnter the password of you database");	
			password = sc.nextLine();

			DBUtils.setPass(password);
			DBUtils.setUsername(username);
		}

	   System.out.println("Success!");
	   
		try {
			DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		}
	   
	   
		mainMenu();

	}
	
	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nHi Welcome to the main menu of your private school"
				+ "\nType the correspoding number for the action to be taken "
				+ "\nIf you want to terminate programm type 99\n"
				+ "\n\n     PRIVATE SCHOOL MENU"
				+ "\n***********************************"
				+ "\n1) Create Data"
				+ "\n2) Assign Data to Data"
				+ "\n3) Delete Data"
				+ "\n4) Display your School Data"
		);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 5) || i == 99);

		switch (input) {
			case 1:
				createData();
				mainMenu();
				break;
			case 2:
				assignDataToData();
				mainMenu();
				break;
			case 3:
				deleteData();
				mainMenu();
				break;
			case 4:
				displayData();
				mainMenu();
				break;
			
			case 99:

				break;
		}
		
		
	}


	public static void createData() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nType the correspoding number for the action to be taken "
				+ "\nIf you want to go back type 99\n"
				+ "\n\n     CREATE DATA MENU"
				+ "\n***********************************"
				+ "\n1) Create Student"
				+ "\n2) Create Trainer"
				+ "\n3) Create Course"
				+ "\n4) Create Assignment"
				+ "\n5) Create Stream of Courses"
				+ "\n6) Create ClassRoom"
				);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 7) || i == 99);

		switch (input) {
			case 1:
				CreateDataFromUserInput.createStudent();
				createData();
				break;
			case 2:
				CreateDataFromUserInput.createTrainer();
				createData();
				break;
			case 3:
				CreateDataFromUserInput.createCourse();
				createData();
				break;
			case 4:
				CreateDataFromUserInput.createAssignment();
				createData();
				break;
			case 5:
				CreateDataFromUserInput.createStream();
				createData();
				break;
			case 6:
				CreateDataFromUserInput.createClassroom();
				createData();
				break;
			
			case 99:

				break;
		}
	}

	public static void assignDataToData() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nASSIGN DATA TO DATA"
				+ "\n**********************"
				+ "\nType the correspoding number for the action to be taken"
				+ "\nTo go back type 99\n"
				+ "\n1) Enroll Student to ClassRoom"
				+ "\n2) Assign  Trainer to ClassRoom"
				+ "\n3) Add Course to Stream"
//				+ "\n4) Add Assignment to Course"
		);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 4) || i == 99);

		switch (input) {
			case 1:
				ChooseAndAssign.enrollStudentToClassroom();
				assignDataToData();
				break;
			case 2:
				ChooseAndAssign.assignTrainerToClassroom();
				assignDataToData();
				break;
			case 3:
				ChooseAndAssign.addCourseToStream();
				assignDataToData();
				break;
//			case 4:
//				ChooseAndAssign.addAssignmentToCourse();
//				assignDataToData();
//				break;
			case 99:
				break;
		}

	}
	
	
	public static void deleteData(){
		Scanner sc = new Scanner(System.in);
		
	System.out.println(	
		"\nType the correspoding number for the action to be taken"
				+ "\nTo go back type 99\n"
				+ "\n\nDELETE YOUR DATA"
				+ "\n**********************"
				+ "\n1) Delete a Student"
				+ "\n2) Delete a Trainer"
				+ "\n3) Delete an Assignment"
				+ "\n4) Delete a Classroom"
				+ "\n5) Delete a Stream"
				+ "\n6) Delete a Course"
				
		);
	
	int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 7) || i == 99);

		switch (input) {
			case 1:
				deleteStudent();
				deleteData();
				break;
			case 2:
				deleteTrainer();
				deleteData();
				break;
			case 3:
				deleteAssignment();
				deleteData();
				break;
			case 4:
				deleteClassroom();
				deleteData();
				break;
			case 5:
				deleteStream();
				deleteData();
				break;
			case 6:
				deleteCourse();
				deleteData();
				break;

			case 99:
				break;
		}

		
	}

	public static void displayData() {

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nType the correspoding number for the action to be taken"
				+ "\nTo go back type 99\n"
				+ "\n\nDISPLAY YOUR DATA"
				+ "\n**********************"
				+ "\n1) Display a list of all the students"
				+ "\n2) Display a list of all the trainers"
				+ "\n3) Display a list of all the assignments"
				+ "\n4) Display a list of all the courses"
				+ "\n5) Display all the ClassRooms"
				+ "\n6) Display all Streams"
				+ "\n7) Display all the students per course"
				+ "\n8) Display all the trainers per course"
				+ "\n9) Display all the assignments per course"
				+ "\n10) Display all the assignments per student"
				+ "\n11) Display a list of students that belong to more than N courses "
				+ "\n12) Display a list of students with assignments to delivered in given week"
		);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 13) || i == 99);

		switch (input) {
			case 1:
				DisplayData.displayAllStudent();
				displayData();
				break;
			case 2:
				DisplayData.displayAllTheTrainers();
				displayData();
				break;
			case 3:
				DisplayData.displayAllTheAssignments();
				displayData();
				break;
			case 4:
				DisplayData.displayAllTheCourses();
				displayData();
				break;
			case 5:
				DisplayData.displayAllClassrooms();
				displayData();
				break;
			case 6:	
				DisplayData.displayAllStreams();
				displayData();
				break;
			case 7:
				DisplayData.displayStudentsPerCourse();
				displayData();
				break;
			case 8:
				DisplayData.displayTrainersPerCourse();
				displayData();
				break;
			case 9:
				DisplayData.displayAssignmentsPerCourse();
				displayData();
				break;
			case 10:
				DisplayData.displayAssignmentsPerStudent();
				displayData();
				break;
			case 11:
				DisplayData.displayStudentsMoreThanNCourses();
				displayData();
				break;
			case 12:
				DisplayData.displayStudentsWithAssignmentInWeek();
				displayData();
				break;

			case 99:
				break;
		}

	}

}
