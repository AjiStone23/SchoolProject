/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulateData;

import JavaConnectionWithSql.DBUtils;
import static ManipulateData.ChooseAndAssign.chooseAndGetClassRoom;
import static ManipulateData.ChooseAndAssign.chooseAndGetCourse;
import static ManipulateData.ChooseAndAssign.chooseAndGetCourseAssignment;
import static ManipulateData.ChooseAndAssign.chooseAndGetStream;
import static ManipulateData.ChooseAndAssign.chooseAndGetStudent;
import static ManipulateData.ChooseAndAssign.chooseAndGetTrainer;
import PrivateSchoolPackage.ClassRoom;
import PrivateSchoolPackage.Course;
import PrivateSchoolPackage.CourseAssignment;
import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Trainer;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ajist
 */
public class DeleteData {
	
	
	
public static void deleteStudent() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE STUDENT"
				+ "\n******************");
		System.out.println("\nChoose a Student");
		Student st = chooseAndGetStudent();

		if (st == null) {
			System.out.println("There is no Student");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deletestudent(" + st.getPersonId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(st);
			System.out.println("Deleted");
		}

	}


public static void deleteTrainer() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE TRAINER"
				+ "\n******************");
		System.out.println("\nChoose a Trainer");
		Trainer tr = chooseAndGetTrainer();

		if (tr == null) {
			System.out.println("There is no Trainer");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deletetrainer(" + tr.getPersonId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(tr);
			System.out.println("Deleted");
		}

	}



public static void deleteClassroom() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE CLASSROOOM"
				+ "\n******************");
		System.out.println("\nChoose a Classroom");
		ClassRoom cl = chooseAndGetClassRoom();

		if (cl == null) {
			System.out.println("There is no ClassRooms");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deleteclassroom(" + cl.getClassRoomId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(cl);
			System.out.println("Deleted");
		}

	}


public static void deleteAssignment() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE ASSIGNMENT"
				+ "\n******************");
		System.out.println("\nChoose an Assignment");
		CourseAssignment ca = chooseAndGetCourseAssignment();

		if (ca == null) {
			System.out.println("There is no Assignments");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deletecourseassignment(" + ca.getCourseAssignmentId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(ca);
			System.out.println("Deleted");
		}

	}




public static void deleteCourse() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE COURSE"
				+ "\n******************");
		System.out.println("\nChoose a Course");
		Course co = chooseAndGetCourse();

		if (co == null) {
			System.out.println("There is no Courses");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deletecourse(" + co.getCourseId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(co);
			System.out.println("Deleted");
		}

	}



public static void deleteStream() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nDELETE STREAM"
				+ "\n******************");
		System.out.println("\nChoose a Stream");
		Stream s = chooseAndGetStream();

		if (s == null) {
			System.out.println("There is no Streams");
			return;

		}

		DBUtils.createConnection();
		int n = 0;
		Statement state;
		try {

			state = DBUtils.getConn().createStatement();
			n = state.executeUpdate("CALL deletestream(" + s.getStreamId() + ")");
			DBUtils.getConn().close();

		} catch (SQLException ex) {

			System.out.println("SQL ex");

		}

		if (n == 0) {
			System.out.println("Something went wrong try again");

		} else {
			System.out.println("Success");
			System.out.println(s);
			System.out.println("Deleted");
		}

	}






}
