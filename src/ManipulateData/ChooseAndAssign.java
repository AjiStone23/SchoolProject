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

import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Trainer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajist
 */
public class ChooseAndAssign {
	
	
	
	public static Student chooseAndGetStudent() {
        Scanner sc =new Scanner(System.in) ;
		Student student=null;
		if(!DisplayData.displayAllStudent())return student;
		
		DBUtils.createConnection();
		
		Statement st;
		boolean b=false;
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Student with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from student where studentid=" + choice);
				
               b=true;
			} while (!result.next());
			
			
			
			student= new Student(result.getString(2),result.getString(3),LocalDate.parse(result.getString(4)),result.getInt(1),result.getFloat(5));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return student;

	}
	
	public static Trainer chooseAndGetTrainer() {
		boolean b=false;
        Scanner sc =new Scanner(System.in) ;
		Trainer trainer=null;
		if(!DisplayData.displayAllTheTrainers())return trainer;
		
		DBUtils.createConnection();
		
		Statement st;
		
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Trainer with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from trainer where trainerid=" + choice);
				b=true;

			} while (!result.next());
			
			
			
			trainer= new Trainer(result.getString(2),result.getString(3),LocalDate.parse(result.getString(4)),result.getInt(1));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return trainer;

	}
	
	
	public static Course chooseAndGetCourse() {
		boolean b=false;
        Scanner sc =new Scanner(System.in) ;
		Course course=null;
		if(!DisplayData.displayAllTheCourses())return course;
		
		DBUtils.createConnection();
		
		Statement st;
		
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Course with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from course where courseid=" + choice);
                 b=true;
			} while (!result.next());
			
			
			
			course= new Course(result.getString(2),LocalDate.parse(result.getString(3)),LocalDate.parse(result.getString(4)),result.getInt(1));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return course;

	}
	
	
	public static CourseAssignment chooseAndGetCourseAssignment() {
		boolean b=false;
        Scanner sc =new Scanner(System.in) ;
		CourseAssignment ass=null;
		if(!DisplayData.displayAllTheAssignments())return ass;
		
		DBUtils.createConnection();
		
		Statement st;
		
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Assignment with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from courseassignment where assignmentid=" + choice);
                  b=true;
			} while (!result.next());
			
			
			
			ass= new CourseAssignment(result.getString(2),result.getString(3),LocalDate.parse(result.getString(4)),result.getInt(5),result.getInt(6),result.getInt(1));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return ass;

	}
	
	
	public static ClassRoom chooseAndGetClassRoom(){
		boolean b=false;
		
		 Scanner sc =new Scanner(System.in) ;
		ClassRoom cl = null;
		if(!DisplayData.displayAllClassrooms())return cl;
		
		DBUtils.createConnection();
		
		Statement st;
		
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Classroom with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from classroom where classroomid=" + choice);
                 b=true;
			} while (!result.next());
			
			
			
			cl= new ClassRoom(result.getString(2),result.getInt(1));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return cl;

			
		
	}
	
	
	
	
	
	
	public static Stream chooseAndGetStream() {
		boolean b=false;
        Scanner sc =new Scanner(System.in) ;
		Stream stream=null;
		if(!DisplayData.displayAllStreams())return stream;
		
		DBUtils.createConnection();
		
		Statement st;
		
		
		try {

			ResultSet result;
			do {
				if(b)System.out.println("There is no Stream with such id, try again!!");
				int choice = Validator.loopAndGetValidInt(sc, (i) -> true);

				st = DBUtils.getConn().createStatement();
				result = st.executeQuery("select* from stream where streamid=" + choice);
                  b=true;
			} while (!result.next());
			
			
			
			stream= new Stream(result.getString(2),result.getInt(1));
			
              DBUtils.getConn().close();
		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return stream;

	}
	
	

	public static void enrollStudentToClassroom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nENROLL STUDENT TO CLASSROOM"
				+ "\n******************");
		System.out.println("\nChoose a Student");
		Student st =chooseAndGetStudent();
		
		if (st == null) {
			System.out.println("No Student found!");
			System.out.println("\nDo you want to create a Student? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createStudent();
				enrollStudentToClassroom();
			}
			return;
		}
		
		System.out.println("\nChoose a Classroom");
		ClassRoom cl = chooseAndGetClassRoom();
		if (cl == null) {
			System.out.println("There is no Classrooms");
			System.out.println("\nDo you want to create a Classroom? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createClassroom();
				enrollStudentToClassroom();
			}
			return;
		}
		
		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("insert into studentperclassroom(studentId,classroomId)values (" + st.getPersonId() + "," + cl.getClassRoomId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("This Student is already enrolled to this classroom");
			
		} else {
			System.out.println("Success");
		}
		
	}

	public static void assignTrainerToClassroom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nASSIGN TRAINER TO CLASSROOM "
				+ "\n******************");
		
		System.out.println("\nChoose a Trainer");
		
		
		Trainer tr =chooseAndGetTrainer();
		
		if (tr == null) {
			System.out.println("There is no Trainer");
			System.out.println("\nDo you want to create a Trainer? y/n");
			String create = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (create.equals("y")) {
				
				CreateDataFromUserInput.createTrainer();
				assignTrainerToClassroom();
			}
			return;
		}
		System.out.println("\nChoose a Classroom");
		ClassRoom cl = chooseAndGetClassRoom();
		if (cl == null) {
               System.out.println("No Classrooms found");
			System.out.println("\nDo you want to create a Classroom? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createCourse();
				assignTrainerToClassroom();
			}
			return;
		}
		
		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("insert into trainerperclassroom(trainerId,classroomId)values (" + tr.getPersonId() + "," + cl.getClassRoomId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("This Trainer is already assigned to this classroom");
			
		} else {
			System.out.println("Success");
		}
		
		
	}

	
	
	public static void addCourseToStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nADD COURSE TO STREAM"
				+ "\n******************");
		System.out.println("\nChoose a Stream");
		Stream str = chooseAndGetStream();
		if (str == null) {
			System.out.println("No streams found");
			System.out.println("\nDo you want to create a Stream? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createStream();
				addCourseToStream();
			}
			return;
		}
		System.out.println("\nChoose a Course");
		Course cr = chooseAndGetCourse();
		if (cr == null) {
			System.out.println("No Courses found");
			System.out.println("\nDo you want to create a Course? y/n");
			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
			if (createAgain.equals("y")) {
				CreateDataFromUserInput.createCourse();
				addCourseToStream();
			}
			return;
		}
		
		
		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("insert into courseperstream(courseId,streamId)values (" + cr.getCourseId() + "," + str.getStreamId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("This Course is already added to this Stream");
			
		} else {
			System.out.println("Success");
		}
		
		
	}

//	public static void addAssignmentToCourse() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("\n\nADD ASSIGNMENT TO COURSE "
//				+ "\n******************");
//		System.out.println("\nChoose a Course");
//		Course cr = chooseAndGetCourse();
//		if (cr == null) {
//			System.out.println("\nDo you want to create a Course? y/n");
//			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
//			if (createAgain.equals("y")) {
//				CreateDataFromUserInput.createCourse();
//				addAssignmentToCourse();
//			}
//			return;
//		}
//		System.out.println("\nChoose an Assignment");
//		CourseAssignment ass = chooseAndGetCourseAssignment();
//		if (ass == null) {
//			System.out.println("\nDo you want to create an Assignment? y/n");
//			String createAgain = Validator.loopAndGetValidString(sc, Validator.forLettersOnly.and(s -> s.equals("y") || s.equals("n")));
//			if (createAgain.equals("y")) {
//				CreateDataFromUserInput.createAssignment();
//				addAssignmentToCourse();
//			}
//			return;
//		}
//		
//		DBUtils.createConnection();
//		int n = 0;
//		Statement state;
//		try {
//
//			state = DBUtils.getConn().createStatement();
//			n = state.executeUpdate("insert into studentperclassroom(studentId,classroomId)values ('" + st.getPersonId() + ",'" + cl.getClassRoomId() + "')");
//			DBUtils.getConn().close();
//
//		} catch (SQLException ex) {
//
//			System.out.println("SQL ex");
//
//		}
//
//		if (n == 0) {
//			System.out.println("This Student is already enrolled to this classroom");
//			
//		} else {
//			System.out.println("Success");
//		}
//		
//		
//		
//		
//		
//		
//		if (cr.addAssignment(ass,theSchool.getSchoolClassrooms())) {
//			System.out.println("Success\n");
//		} else {
//			System.out.println("This assignment is already added to this course!\n");
//		}
//	}
}
