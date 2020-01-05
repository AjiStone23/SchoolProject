/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import PrivateSchoolPackage.ClassRoom;
import PrivateSchoolPackage.Course;
import PrivateSchoolPackage.CourseAssignment;
import PrivateSchoolPackage.IschoolObject;
import PrivateSchoolPackage.PrivateSchool;
import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Trainer;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ajist
 */
public class ChooseAndAssign {
	
	public static <T extends IschoolObject> T chooseSchoolObject(HashSet<T> setOfT) {

		Scanner sc = new Scanner(System.in);
		T target = null;

		if (setOfT.isEmpty()) {
			System.out.println("There is none!");
			return target;
		}
		System.out.println("To choose enter the corresponding  code\n");
		setOfT.forEach((s) -> System.out.println(s));

		int input = Validator.loopAndGetValidInt(sc, (i) -> {
			for (T t : setOfT) {
				if (t.getSchoolObjectCode() == i) {

					return true;
				}
			}
			return false;
		});

		for (T t : setOfT) {
			if (t.getSchoolObjectCode() == input) {
				target = t;

			}

		}
		return target;
	}

	public static void enrollStudentToClassroom(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nENROLL STUDENT TO CLASSROOM"
				+ "\n******************");
		System.out.println("\nChoose a Student");
		Student st = chooseSchoolObject(theSchool.getSchoolStudents());
		if (st == null) {
			System.out.println("\nDo you want to create a Student? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createStudent(theSchool);
				enrollStudentToClassroom( theSchool);
			}
			return;
		}
		System.out.println("\nChoose a Classroom");
		ClassRoom cl = chooseSchoolObject(theSchool.getSchoolClassrooms());
		if (cl == null) {
			System.out.println("\nDo you want to create a Classroom? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createClassroom(theSchool);
				enrollStudentToClassroom(theSchool);
			}
			return;
		}
		if (cl.addStudent(st)) {
			System.out.println("Success\n");
		} else {
			System.out.println("This student is already enrolled to this Classroom!\n");
		}
	}

	public static void assignTrainerToClassroom(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nASSIGN TRAINER TO CLASSROOM "
				+ "\n******************");
		System.out.println("\nChoose a Trainer");
		Trainer tr = chooseSchoolObject(theSchool.getSchoolTrainers());
		if (tr == null) {

			System.out.println("\nDo you want to create a Trainer? y/n");
			String create = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (create.equals("y")) {
				CreateDataFromUserInput.createTrainer(theSchool);
				assignTrainerToClassroom(theSchool);
			}
			return;
		}
		System.out.println("\nChoose a Classroom");
		ClassRoom cl = chooseSchoolObject(theSchool.getSchoolClassrooms());
		if (cl == null) {

			System.out.println("\nDo you want to create a Classroom? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createCourse(theSchool);
				assignTrainerToClassroom(theSchool);
			}
			return;
		}
		if (cl.addTrainer(tr)) {
			System.out.println("Success\n");
		} else {
			System.out.println("This trainer is already assigned to this Classroom!\n");
		}
	}

	
	public static void addCourseToStream(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nADD COURSE TO STREAM"
				+ "\n******************");
		System.out.println("\nChoose a Stream");
		Stream str = chooseSchoolObject(theSchool.getSchoolStreams());
		if (str == null) {
			System.out.println("\nDo you want to create a Stream? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createStream(theSchool);
				addCourseToStream(theSchool);
			}
			return;
		}
		System.out.println("\nChoose a Course");
		Course cr = chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {
			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createCourse(theSchool);
				addCourseToStream( theSchool);
			}
			return;
		}
		if (str.addCourse(cr)) {
			System.out.println("Success\n");
		} else {
			System.out.println("This course already belongs to the Stream!\n");
		}

	}

	public static void addAssignmentToCourse(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nADD ASSIGNMENT TO COURSE "
				+ "\n******************");
		System.out.println("\nChoose a Course");
		Course cr = chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {
			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createCourse(theSchool);
				addAssignmentToCourse(theSchool);
			}
			return;
		}
		System.out.println("\nChoose an Assignment");
		CourseAssignment ass = chooseSchoolObject(theSchool.getAssignments());
		if (ass == null) {
			System.out.println("\nDo you want to create an Assignment? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createAssignment(theSchool);
				addAssignmentToCourse(theSchool);
			}
			return;
		}
		if (cr.addAssignment(ass,theSchool.getSchoolClassrooms())) {
			System.out.println("Success\n");
		} else {
			System.out.println("This assignment is already added to this course!\n");
		}
	}
}
