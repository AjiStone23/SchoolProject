/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import PrivateSchoolPackage.ClassRoom;
import PrivateSchoolPackage.Course;
import PrivateSchoolPackage.CourseAssignment;
import PrivateSchoolPackage.PrivateSchool;
import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Subject;
import PrivateSchoolPackage.TimeType;
import PrivateSchoolPackage.Trainer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ajist
 */
public class CreateDataFromUserInput {
	
	private static PrivateSchool theSchool;

	
	
	public static PrivateSchool getTheSchool() {
		return theSchool;
	}
	
	
	
	
	
	public static void createPrivateSchool() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\nType a name for the Private School");
		String schoolName = Validator.loopAndGetValidString(sc, Validator.forLettersOnly);

		theSchool = new PrivateSchool(schoolName);

	}

	public static void createStudent(PrivateSchool theSchool) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE STUDENT "
				+ "\n******************");
		System.out.println("Type the first name of the Student (Up to 15 letters)");
		String firstName = Validator.loopAndGetValidString(sc, Validator.forLettersOnly);

		System.out.println("Enter the last name of the Student (Up to 15 letters)");
		String lastName = Validator.loopAndGetValidString(sc, Validator.forLettersOnly);

		System.out.println("Enter the date of birthof the Student yyyy-MM-dd(e.g.1999-05-28)");
		LocalDate afterThisDate = LocalDate.of(1910, 1, 1);
		LocalDate beforeThisDate = LocalDate.of(2014, 1, 1);

		LocalDate dateOfBirth = Validator.loopAndGetValidDate(sc, d -> d.isAfter(afterThisDate) && d.isBefore(beforeThisDate));
		Student st = new Student(firstName, lastName, dateOfBirth);
		if (theSchool.getSchoolPopulation().add(st) == false) {
			System.out.println("This person has already been created!");
			return;
		}
		theSchool.getSchoolPopulation().add(st);
		theSchool.getSchoolStudents().add(st);

		System.out.println("\nStudent created.");
		System.out.println(st);
		System.out.println("\nEnter the fees of the student (e.g. 500.0)");
		float fees = Validator.loopAndGetValidFloat(sc, f -> f >= 0.0);
		st.setTuitionFees(fees);

		System.out.println("\nDo you want to create another Student? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createStudent(theSchool);
		}

	}

	public static void createTrainer(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE TRAINER "
				+ "\n******************");
		System.out.println("Type the first name of the Trainer (Up to 15 letters)");
		String firstName = Validator.loopAndGetValidString(sc, Validator.forLettersOnly);

		System.out.println("Enter the last name of the Trainer");
		String lastName = Validator.loopAndGetValidString(sc, Validator.forLettersOnly);

		System.out.println("Enter the date of birthof the Trainer yyyy-MM-dd(e.g.1999-05-28)");
		LocalDate afterThisDate = LocalDate.of(1910, 1, 1);
		LocalDate beforeThisDate = LocalDate.of(2004, 1, 1);

		LocalDate dateOfBirth = Validator.loopAndGetValidDate(sc, d -> d.isAfter(afterThisDate) && d.isBefore(beforeThisDate));
		Trainer tr = new Trainer(firstName, lastName, dateOfBirth);
		if (theSchool.getSchoolPopulation().add(tr) == false) {
			System.out.println("This person has already been created!");
			return;
		}
		theSchool.getSchoolPopulation().add(tr);
		theSchool.getSchoolTrainers().add(tr);

		System.out.println("\nTrainer created.");
		System.out.println(tr);

		System.out.println("Choose the subject of the Trainer");
		System.out.println("1) " + Subject.COMPUTER_SCIENCE);
		System.out.println("2) " + Subject.MATH);
		int input = Validator.loopAndGetValidInt(sc, (i) -> i.equals(1) || i.equals(2));
		if (input == 1) {
			tr.setSubject(Subject.COMPUTER_SCIENCE);
		}
		tr.setSubject(Subject.MATH);

		System.out.println("\nDo you want to create another Trainer? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createTrainer(theSchool);
		}

	}

	public static void createCourse(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE COURSE "
				+ "\n******************");
		System.out.println("Type the title of the Course (Up to 15 letters and digits)");
		String courseTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		System.out.println("Enter the starting date of the Course  yyyy-MM-dd(e.g.2020-05-28)");
		LocalDate afterThisDate = LocalDate.now().minusDays(1);

		LocalDate startingDate = Validator.loopAndGetValidDate(sc, d -> d.isAfter(afterThisDate));

		System.out.println("Enter the ending date of the Course  yyyy-MM-dd(e.g.2020-05-28)");

		LocalDate endDate = Validator.loopAndGetValidDate(sc, d -> d.isAfter(startingDate.minusDays(1)));
		Course cr = new Course(courseTitle, startingDate, endDate);
		if (theSchool.getSchoolCourses().add(cr) == false) {
			System.out.println("\nThis course has already been created!");
			return;
		}
		System.out.println("\nCourse created.");
		System.out.println(cr);

		System.out.println("\nChoose the Timetype of the Course");
		System.out.println("1) " + TimeType.FULL_TIME);
		System.out.println("2) " + TimeType.PART_TIME);
		int input = Validator.loopAndGetValidInt(sc, (i) -> i.equals(1) || i.equals(2));
		if (input == 1) {
			cr.setTimetype(TimeType.FULL_TIME);
		}
		cr.setTimetype(TimeType.PART_TIME);

		System.out.println("\nDo you want to create another Course? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createCourse(theSchool);
		}

	}

	public static void createAssignment(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE ASSIGNMENT "
				+ "\n******************");
		System.out.println("Type the title of the Assignment (Up to 15 letters and digits)");
		String assignmentTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		System.out.println("Enter the deadline of the Assignment  yyyy-MM-dd(e.g.2020-05-28)");
		System.out.println("Saturday or Sunday considered invalid");

		LocalDate afterThisDate = LocalDate.now().minusDays(1);

		Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

		LocalDate deadline = Validator.loopAndGetValidDate(sc, d -> d.isAfter(afterThisDate) && !(weekend.contains(d.getDayOfWeek())));
		CourseAssignment ca = new CourseAssignment(assignmentTitle, deadline);
		if (theSchool.getAssignments().add(ca) == false) {
			System.out.println("\nThis Assignment has already been created!");
			System.out.println("\nDo you want to create another Assignment? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				createAssignment(theSchool);
			}
			return;
		}

		System.out.println("\nAssignment created.");
		System.out.println(ca);

		System.out.println("\nType an Assignment description");
		String description = sc.nextLine();
		ca.setDescription(description);

		System.out.println("\nDo you want to create another Assignment? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createAssignment(theSchool);
		}

	}

	public static void createStream(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE STREAM "
				+ "\n******************");
		System.out.println("Type the title of the Stream (Up to 15  letters and digits)");
		String streamTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		Stream str = new Stream(streamTitle);
		if (theSchool.getSchoolStreams().add(str) == false) {
			System.out.println("\nThis stream has already been created!");
			System.out.println("\nDo you want to create another Stream? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				createStream(theSchool);
			}
			return;
		}
		System.out.println("\nStream created.");
		System.out.println(str);

		System.out.println("\nDo you want to create another Stream? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createStream(theSchool);
		}
	}

	public static void createClassroom(PrivateSchool theSchool) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE CLASSROOM "
				+ "\n******************");
		System.out.println("Type the title of the ClassRoom (Up to 15 letters and digits)");
		String classroomTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		System.out.println("\nSelect a course");
		Course cr =ChooseAndAssign.chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {

			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				createCourse(theSchool);
				createClassroom( theSchool);
			}
			return;
		}
		ClassRoom cl = new ClassRoom(classroomTitle, cr);

		if (theSchool.getSchoolClassrooms().add(cl) == false) {
			System.out.println("\nThis Classroom has already been created!");
			System.out.println("\nDo you want to create another Classroom? y/n");

			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				createClassroom(theSchool);
			}
			return;
		}
		System.out.println("\nClassRoom created.");
		System.out.println(cl);
		System.out.println("\nDo you want to create another Classroom? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createClassroom(theSchool);
		}
	}

	
}
