/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulateData;

import JavaConnectionWithSql.DBUtils;
import PrivateSchoolPackage.ClassRoom;
import PrivateSchoolPackage.Course;
import PrivateSchoolPackage.CourseAssignment;
import PrivateSchoolPackage.PrivateSchool;
import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Subject;
import PrivateSchoolPackage.TimeType;
import PrivateSchoolPackage.Trainer;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public static void createStudent() {

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
		Student student = new Student(firstName, lastName, dateOfBirth);
		System.out.println("\nEnter the fees of the student (e.g. 500.0)");
		float fees = Validator.loopAndGetValidFloat(sc, f -> f >= 0.0 && f <= 99999999.99);
		student.setTuitionFees(fees);

		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into student(firstName,lastName,dateOfBirth,tuitionfees)values ('" + student.getFirstName() + "','" + student.getLastName() + "','" + student.getDateOfBirth() + "','" + student.getTuitionFees() + "')");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("This Student has already been created!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nStudent created.");
		System.out.println(student);

		System.out.println("\nDo you want to create another Student? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createStudent();
		}

	}

	public static void createTrainer() {

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
		Trainer trainer = new Trainer(firstName, lastName, dateOfBirth);

		System.out.println("Choose the subject of the Trainer");
		System.out.println("1) " + Subject.COMPUTER_SCIENCE);
		System.out.println("2) " + Subject.MATH);
		int input = Validator.loopAndGetValidInt(sc, (i) -> i.equals(1) || i.equals(2));
		if (input == 1) {
			trainer.setSubject(Subject.COMPUTER_SCIENCE);
		}
		trainer.setSubject(Subject.MATH);

		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into trainer(firstName,lastName,dateOfBirth,subjectId)values ('" + trainer.getFirstName() + "','" + trainer.getLastName() + "','" + trainer.getDateOfBirth() + "','" + input + "')");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			System.out.println("SQL ex");
			return;
		}

		if (n == 0) {
			System.out.println("This trainer has already been created!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nTrainer created.");
		System.out.println(trainer);

		System.out.println("\nDo you want to create another Trainer? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createTrainer();
		}

	}

	public static void createCourse() {

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
		Course course = new Course(courseTitle, startingDate, endDate);

		System.out.println("\nChoose the Timetype of the Course");
		System.out.println("1) " + TimeType.FULL_TIME);
		System.out.println("2) " + TimeType.PART_TIME);
		int input = Validator.loopAndGetValidInt(sc, (i) -> i.equals(1) || i.equals(2));
		if (input == 1) {
			course.setTimetype(TimeType.FULL_TIME);
		}
		course.setTimetype(TimeType.PART_TIME);

		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into course(coursetitle,start_Date,end_Date,timeTypeId)values ('" + course.getCourseTitle() + "','" + course.getStart_Date() + "','" + course.getEnd_Date() + "','" + input + "')");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			System.out.println("SQL ex");
			return;
		}

		if (n == 0) {
			System.out.println("This course has already been created!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nCourse created.");
		System.out.println(course);

		System.out.println("\nDo you want to create another Course? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createCourse();
		}
	}

	public static void createAssignment() {
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
		CourseAssignment ass = new CourseAssignment(assignmentTitle, deadline);

		System.out.println("\nType an Assignment description");
		String description = Validator.loopAndGetValidString(sc, s -> s.trim().matches("[a-z A-Z_0-9]{1,150}"));
		ass.setDescription(description);

		System.out.println("Choose a Course to add the assignment to,deadline of the assignment must be between start date and end date of the course");
		 Course course= ChooseAndAssign.chooseAndGetCourse();
		
		if (course == null) {
			System.out.println("No course found");
			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {

				CreateDataFromUserInput.createCourse();
				System.out.println("Choose a Course to add the assignment to,deadline of the assignment must be between start date and end date of the course");
				course = ChooseAndAssign.chooseAndGetCourse();

			} else {
				return;
			}

		}
		
		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into courseassignment (assignmentTitle,assignmentDescription,deadline,maxOralMark,maxTotalMark,courseId) values ('" + ass.getTitle() + "','" + ass.getDescription() + "','" + ass.getDeadLine() + "'," + 30 + "," + 100 + ","+course.getCourseId()+")");                  
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			System.out.println("SQL ex");
		}

		if (n == 0) {
			System.out.println("Wrong deadline or duplicate assignment!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nAssignment created.");
		System.out.println(ass);

		System.out.println("\nDo you want to create another Assignment? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createAssignment();
		}

	}

	public static void createStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE STREAM "
				+ "\n******************");
		System.out.println("Type the title of the Stream (Up to 15  letters and digits)");
		String streamTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		Stream str = new Stream(streamTitle);

		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into stream(streamtitle)values ('" + str.getStreamTitle() + "')");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			System.out.println("SQL ex");
		}

		if (n == 0) {
			System.out.println("This stream has already been created!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nStream created.");
		System.out.println(str);

		System.out.println("\nDo you want to create another Stream? y/n");
		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createStream();
		}
	}

	public static void createClassroom() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nCREATE CLASSROOM "
				+ "\n******************");
		System.out.println("Type the title of the ClassRoom (Up to 15 letters and digits)");
		String classroomTitle = Validator.loopAndGetValidString(sc, Validator.forLettersAndDigits);

		System.out.println("\nSelect a course");
		Course cr = ChooseAndAssign.chooseAndGetCourse();
		if (cr == null) {
            System.out.println("No course found");
			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				createCourse();
				createClassroom();
			}
			return;
		}
            System.out.println(cr);
		ClassRoom cl = new ClassRoom(classroomTitle);

		DBUtils.createConnection();
		int n = 0;
		Statement st;
		try {

			st = DBUtils.getConn().createStatement();
			n = st.executeUpdate("insert into classroom(classroomtitle,courseId) values ('" + cl.getClassRoomTitle() + "'," + cr.getCourseId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("This classroom has already been created!");
			return;
		} else {
			System.out.println("Success");
		}

		System.out.println("\nClassroom created.");
		System.out.println(cl);

		System.out.println("\nDo you want to create another Classroom? y/n");

		String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
		if (createAgain.equals("y")) {
			createClassroom();
		}

	}

}
