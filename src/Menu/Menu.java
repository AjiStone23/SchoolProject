/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import PrivateSchoolPackage.PrivateSchool;
import java.util.Scanner;

/**
 *
 * @author ajist
 */
public class Menu {

	public static void start() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Hi, welcome to the PrivateSchool menu! "
				+ "\nType the correspoding number for the action to be taken or type 99 to terminate programm\n "
				+ "\n1) Use synthetic Random School"
				+ "\n2) Create your own School");

		int input = Validator.loopAndGetValidInt(sc, (i) -> i.equals(1) || i.equals(2) || i.equals(99));

		switch (input) {
			case 1:
				RandomSyntheticData.createSytheticData();

				createYourOwnData(RandomSyntheticData.getRdmSchool());

				break;
			case 2:
				CreateDataFromUserInput.createPrivateSchool();
				createYourOwnData(CreateDataFromUserInput.getTheSchool());
				break;
			case 99:
				break;
		}

	}


	public static void createYourOwnData(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE YOUR OWN DATA "
				+ "\n************************"
				+ "\nType the correspoding number for the action to be taken "
				+ "\nIf you want to terminate programm type 99\n"
				+ "\n1) Create Student"
				+ "\n2) Create Trainer"
				+ "\n3) Create Course"
				+ "\n4) Create Assignment"
				+ "\n5) Create Stream of Courses"
				+ "\n6) Create ClassRoom"
				+ "\n7) Assign Data to Data"
				+ "\n8) Display your School Data");

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 9) || i == 99);

		switch (input) {
			case 1:
				CreateDataFromUserInput.createStudent(theSchool);
				createYourOwnData(theSchool);
				break;
			case 2:
				CreateDataFromUserInput.createTrainer(theSchool);
				createYourOwnData(theSchool);
				break;
			case 3:
				CreateDataFromUserInput.createCourse(theSchool);
				createYourOwnData(theSchool);
				break;
			case 4:
				CreateDataFromUserInput.createAssignment(theSchool);
				createYourOwnData(theSchool);
				break;
			case 5:
				CreateDataFromUserInput.createStream(theSchool);
				createYourOwnData(theSchool);
				break;
			case 6:
				CreateDataFromUserInput.createClassroom(theSchool);
				createYourOwnData(theSchool);
				break;
			case 7:
				assignDataToData(theSchool);
				createYourOwnData(theSchool);
				break;
			case 8:
				displayData(theSchool);
				createYourOwnData(theSchool);
			case 99:

				break;
		}
	}

	public static void assignDataToData(PrivateSchool theSchool) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nASSIGN DATA TO DATA"
				+ "\n**********************"
				+ "\nType the correspoding number for the action to be taken"
				+ "\nTo go back type 99\n"
				+ "\n1) Enroll Student to ClassRoom"
				+ "\n2) Assign  Trainer to ClassRoom"
				+ "\n3) Add Course to Stream"
				+ "\n4) Add Assignment to Course"
		);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 5) || i == 99);

		switch (input) {
			case 1:
				ChooseAndAssign.enrollStudentToClassroom(theSchool);
				assignDataToData(theSchool);
				break;
			case 2:
				ChooseAndAssign.assignTrainerToClassroom(theSchool);
				assignDataToData(theSchool);
				break;
			case 3:
				ChooseAndAssign.addCourseToStream(theSchool);
				assignDataToData(theSchool);
				break;
			case 4:
				ChooseAndAssign.addAssignmentToCourse(theSchool);
				assignDataToData(theSchool);
				break;
			case 99:
				break;
		}

	}

	public static void displayData(PrivateSchool theSchool) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDISPLAY YOUR DATA"
				+ "\n**********************"
				+ "\nType the correspoding number for the action to be taken"
				+ "\nTo go back type 99\n"
				+ "\n1) Display a list of all the students"
				+ "\n2) Display a list of all the trainers"
				+ "\n3) Display a list of all the assignments"
				+ "\n4) Display a list of all the courses"
				+ "\n5) Display all the students per course"
				+ "\n6) Display all the trainers per course"
				+ "\n7) Display all the assignments per course"
				+ "\n8) Display all the assignments per student"
				+ "\n9) Display a list of students that belong to more than one course "
				+ "\n10) Display a list of students with assignments to delivered in given week"
		);

		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 11) || i == 99);

		switch (input) {
			case 1:

				DisplayData.displayAllStudent(theSchool);
				displayData(theSchool);
				break;
			case 2:

				DisplayData.displayAllTheTrainers(theSchool);
				displayData(theSchool);
				break;
			case 3:

				DisplayData.displayAllTheAssignments(theSchool);
				displayData(theSchool);
				break;
			case 4:

				DisplayData.displayAllTheCourses(theSchool);
				displayData(theSchool);
				break;
			case 5:
				DisplayData.displayStudentsPerCourse(theSchool);
				displayData(theSchool);
				break;
			case 6:
				DisplayData.displayTrainersPerCourse(theSchool);
				displayData(theSchool);
				break;
			case 7:
				DisplayData.displayAssignmentsPerCourse(theSchool);
				displayData(theSchool);
				break;
			case 8:
				DisplayData.displayAssignmentsPerStudent(theSchool);
				displayData(theSchool);
				break;
			case 9:
				DisplayData.displayStudentsMoreThanOneCourse(theSchool);
				displayData(theSchool);
				break;
			case 10:
				DisplayData.displayStudentsWithAssignmentInWeek(theSchool);
				displayData(theSchool);
				break;

			case 99:
				break;
		}

	}

}
