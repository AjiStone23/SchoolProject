/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulateData;

import JavaConnectionWithSql.DBUtils;

import PrivateSchoolPackage.Course;

import PrivateSchoolPackage.Student;

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
public class DisplayData {

	public static void displayTable(ResultSet table) {

	}

	public static boolean displayAllStudent() {
		boolean b = false;

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from student");

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-8g| %n";

			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format("|                    S  T  U  D  E  N  T  S                         |%n");
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |  FEES   |%n");
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
			}

			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static boolean displayAllTheTrainers() {
		boolean b = false;

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from trainerview");

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-19s| %n";
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			System.out.format("|                       T  R  A  I  N  E  R  S                                 |%n");
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |      SUBJECT       |%n");
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
			}

			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;
	}

	public static boolean displayAllTheAssignments() {

		DBUtils.createConnection();

		boolean b = false;

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from courseassignmentview");

			String leftAlignFormat = "| %-4d | %-30s | %-14s| %-7d| %-7d| %-38s|%n";
			System.out.format("+-----------------------------------------------------------------------------------------------------------------+%n");
			System.out.format("|                                      A  S  S  I  G  N  M  E  N  T  S                                            |%n");
			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");
			System.out.format("| ID   |            TITLE               |  DEADLINE     |MAX ORAL|MAXTOTAL|        COURSE OF THE ASSIGNMENT       |%n");
			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(4), result.getInt(5), result.getInt(6), result.getString(7));
			}

			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

		return b;
	}

	public static boolean displayAllTheCourses() {
		boolean b = false;

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from courseview");

			String leftAlignFormat = "| %-4d | %-35s | %-14s| %-14s| %-12s| %-7d| %n";
			System.out.format("+---------------------------------------------------------------------------------------------------+%n");
			System.out.format("|                                  C  O  U  R  S  E  S                                              |%n");
			System.out.format("+------+-------------------------------------+---------------+---------------+------------+---------+%n");
			System.out.format("| ID   |           COURSE    TITLE           |  START DATE   |    END DATE   |  TIMETYPE  | STUDENTS|%n");
			System.out.format("+------+-------------------------------------+---------------+---------------+------------+---------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6));
			}

			System.out.format("+------+-------------------------------------+---------------+---------------+----------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;
	}

	public static boolean displayAllClassrooms() {
		boolean b = false;

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from classroomview");

			String leftAlignFormat = "| %-4d | %-35s | %-37s | %-12s| %-11s| %-10s|   %-7d| %n";
			System.out.format("+--------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format("|                                          C  L  A  S  S  R  O  O  M  S                                                                |%n");
			System.out.format("+------+-------------------------------------+---------------------------------------+-------------+------------+-----------+----------+%n");
			System.out.format("| ID   |           CLASSROOM    TITLE        |                COURSE TITLE           | START DATE  |  END DATE  | TIMETYPE  | ENROLLED |%n");
			System.out.format("+------+-------------------------------------+---------------------------------------+-------------+------------+-----------+----------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
			}

			System.out.format("+------+-------------------------------------+---------------------------------------+-------------+------------+-----------+----------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static boolean displayAllStreams() {

		boolean b = false;

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from streamview");

			String leftAlignFormat = "| %-4d | %-30s|   %-9d|%n";
			System.out.format("+---------------------------------------------------+%n");
			System.out.format("|                   S T R E A M S                   |%n");
			System.out.format("+------+-------------------------------+------------+%n");
			System.out.format("| ID   |        STREAM  TITLE          |COURSE COUNT|%n");
			System.out.format("+------+-------------------------------+------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getInt(3));
			}

			System.out.format("+------+-------------------------------+------------+%n");

			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static boolean displayStudentsPerCourse() {
		System.out.println("Type the corresponding id to Choose Course");
		boolean b = false;

		Course cr = ChooseAndAssign.chooseAndGetCourse();
		if (cr == null) {
			return b;
		}

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from student where studentid in (select studentid from studentperclassroom where classroomid in (select classroomid from classroom where courseid=" + cr.getCourseId() + "))");

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-8g| %n";
			String headformat = "| %-21s %-41s |%n";
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format(headformat, " S T U D E N T S  O F  ", cr.getCourseTitle());
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |  FEES   |%n");
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
			}

			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static boolean displayTrainersPerCourse() {
		System.out.println("Type the corresponding id to Choose Course");
		boolean b = false;

		Course cr = ChooseAndAssign.chooseAndGetCourse();
		if (cr == null) {
			return b;
		}

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from trainerview where trainerid in (select trainerid from trainerperclassroom where classroomid in (select classroomid from classroom where courseid=" + cr.getCourseId() + "))");

			String headformat = "|  %-25s %-50s|%n";

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-19s| %n";
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			System.out.format(headformat, " T R A I N E R S  O F  ", cr.getCourseTitle().toUpperCase());
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |      SUBJECT       |%n");
			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
			}

			System.out.format("+------+----------------+---------------+-----------------+--------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static boolean displayAssignmentsPerCourse() {

		System.out.println("Type the corresponding id to Choose Course");
		boolean b = false;

		Course cr = ChooseAndAssign.chooseAndGetCourse();
		if (cr == null) {
			return b;
		}

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from courseassignmentview where assignmentid in(select assignmentid from courseassignment where courseid =" + cr.getCourseId() + ")");

			String headAlign = "|        %-35s %-52s |%n";
			String leftAlignFormat = "| %-4d | %-30s | %-14s| %-7d| %-7d| %-38s|%n";

			System.out.format("+-----------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(headAlign, " A S S I G N M E N T S  O F", cr.getCourseTitle().toUpperCase());
			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");
			System.out.format("| ID   |            TITLE               |  DEADLINE     |MAX ORAL|MAXTOTAL|        COURSE OF THE ASSIGNMENT       |%n");
			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(4), result.getInt(5), result.getInt(6), result.getString(7));

			}
			System.out.format("+------+--------------------------------+---------------+--------+--------+---------------------------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

	public static void displayStudentsMoreThanNCourses() {

		DBUtils.createConnection();

		Scanner sc = new Scanner(System.in);
		System.out.println("Type an integer n to display students with more than n courses");
		int input = Validator.loopAndGetValidInt(sc, (i) -> (i > 0 && i < 50));

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select * from student where studentId in (SELECT studentId FROM(SELECT studentId,COUNT(classRoomId) AS num from studentperclassroom group by studentId) AS tempor WHERE NUM>" + input + ")");

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-8g| %n";
			String headformat = "|%-41s %-3s  %-14s |%n";
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format(headformat, " S T U D E N T S  W I T H   M O R E  T H A N  ", input, " C O U R S E S");
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |  FEES   |%n");
			System.out.format("+------+----------------+---------------+-----------------+---------+%n");

			while (result.next()) {

				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
			}

			System.out.format("+------+----------------+---------------+-----------------+---------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void displayStudentsWithAssignmentInWeek() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  date to check who has assignment for this week.   yyyy-MM-dd(e.g.2020-05-28)");

		LocalDate inputDate = Validator.loopAndGetValidDate(sc, s -> true);
		int weekDayValue = inputDate.getDayOfWeek().getValue();

		LocalDate startDate = inputDate.minusDays(weekDayValue);
		LocalDate endDate = startDate.plusDays(6);

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("SELECT  s.studentId ,s.firstName ,s.lastName ,s.dateOfBirth, ca.assignmentTitle,ca.deadline FROM student s \n"
					+ "inner join studentassignment sa\n"
					+ "on s.studentid=sa.studentid\n"
					+ "inner join courseassignment ca\n"
					+ "on sa.assignmentid=ca.assignmentid\n"
					+ "where \n"
					+ " ca.deadline BETWEEN '" + startDate + "'and '" + endDate + "'");

			String leftAlignFormat = "| %-4d | %-14s | %-14s|  %-14s | %-27s| %-12s| %n";
			String headformat = "|    %-36s %-12s %-5s   %-38s|%n";
			System.out.format("+----------------------------------------------------------------------------------------------------+%n");
			System.out.format(headformat, "     STUDENTS WITH ASSIGNMENT FROM  ", startDate, " AND ", endDate);
			System.out.format("+------+----------------+---------------+-----------------+----------------------------+-------------+%n");
			System.out.format("| ID   |  FIRST NAME    |   LAST NAME   |  DATE OF BIRTH  |     ASSIGNMENT TITLE       |   DEADLINE  |%n");
			System.out.format("+------+----------------+---------------+-----------------+----------------------------+-------------+%n");

			while (result.next()) {

				System.out.format(leftAlignFormat, result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
			}

			System.out.format("+------+----------------+---------------+-----------------+----------------------------+-------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static boolean displayAssignmentsPerStudent() {

		System.out.println("Type the corresponding id to choose Student");
		boolean b = false;

		Student stu = ChooseAndAssign.chooseAndGetStudent();
		if (stu == null) {
			return b;
		}

		DBUtils.createConnection();

		try {

			Statement st = DBUtils.getConn().createStatement();

			ResultSet result = st.executeQuery("select* from studentassignmentview  where studentid =" + stu.getPersonId());

			String headAlign = "|    %-35s %-90s |%n";
			String leftAlignFormat = "| %-4d | %-30s | %-14s| %-14s| %-7d| %-7d| %-7d| %-7d| %-38s|%n";

			System.out.format("+---------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(headAlign, "                        A S S I G N M E N T S   O F", stu.getFirstName() + "  " + stu.getLastName());
			System.out.format("+------+--------------------------------+---------------+---------------+--------+--------+--------+--------+---------------------------------------+%n");
			System.out.format("| ID   |              TITLE             |  DEADLINE     |  SUB DATE     |MAX ORAL|MAXTOTAL| ORAL   |  TOTAL |         COURSE  TITLE                 |%n");
			System.out.format("+------+--------------------------------+---------------+---------------+--------+--------+--------+--------+---------------------------------------+%n");

			while (result.next()) {
				b = true;
				System.out.format(leftAlignFormat, result.getInt(1), result.getString(3), result.getString(5), result.getString(6),
						result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10), result.getString(4));

			}
			System.out.format("+------+--------------------------------+---------------+---------------+--------+--------+--------+--------+---------------------------------------+%n");
			DBUtils.getConn().close();

		} catch (SQLException ex) {
			Logger.getLogger(DisplayData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return b;

	}

}
