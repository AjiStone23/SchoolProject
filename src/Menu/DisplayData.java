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
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.StudentAssignment;
import PrivateSchoolPackage.Trainer;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author ajist
 */
public class DisplayData {
	
	
	public static void displayAllStudent(PrivateSchool theSchool){
		System.out.println("LIST OF ALL THE STUDENTS\n*****************");
				theSchool.getSchoolStudents().forEach(s -> System.out.println(s));
	}
	
	public static void displayAllTheTrainers(PrivateSchool theSchool){
		System.out.println("LIST OF ALL THE TRAINERS\n*****************");
				theSchool.getSchoolTrainers().forEach(t -> System.out.println(t));
	}
	
	public static void displayAllTheAssignments(PrivateSchool theSchool){
		System.out.println("LIST OF ALL THE ASSIGNMENTS\n*****************");
				theSchool.getAssignments().forEach(a -> System.out.println(a));
	}
	
	public static void displayAllTheCourses(PrivateSchool theSchool){
		System.out.println("LIST OF ALL THE COURSES\n*****************");
				theSchool.getSchoolCourses().forEach(c -> System.out.println(c));
	}
	
	
	
	public static void displayStudentsPerCourse(PrivateSchool theSchool) {
		System.out.println("Choose Course");

		Course cr = ChooseAndAssign.chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {
			return;
		}

		System.out.println("LIST OF ALL THE STUDENTS OF COURSE: " + cr.getTitle() + " \n*****************");

		
		for (ClassRoom cl : theSchool.getSchoolClassrooms()) {
			if (cl.getTheCourse().equals(cr)) {

				for (Student stu : cl.getStudents()) {
					System.out.println(stu);

				}
			}

		}

	}

	public static void displayTrainersPerCourse(PrivateSchool theSchool) {
		System.out.println("Choose Course");
		Course cr =ChooseAndAssign.chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {
			return;
		}

		System.out.println("LIST OF ALL THE TRAINERS OF COURSE:" + cr.getTitle() + " \n*****************");


		for (ClassRoom cl : theSchool.getSchoolClassrooms()) {
			if (cl.getTheCourse().equals(cr)) {

				for (Trainer tra : cl.getTrainers()) {
					System.out.println(tra);

				}

			}

		}

	}

	public static void displayAssignmentsPerCourse(PrivateSchool theSchool) {
		System.out.println("Choose Course");
		Course cr = ChooseAndAssign.chooseSchoolObject(theSchool.getSchoolCourses());
		if (cr == null) {
			return;
		}
		System.out.println("LIST OF ALL THE ASSIGNMENTS OF COURSE:" + cr.getTitle() + " \n*****************");


		boolean notFound = true;
		for (CourseAssignment ca : cr.getCourseAssignments()) {

			System.out.println(ca);

		}
		if (cr.getCourseAssignments().isEmpty()) {
			System.out.println("There is no Assignments");
		}
	}

	public static void displayAssignmentsPerStudent(PrivateSchool theSchool) {

		System.out.println("Choose Student");
		Student st = ChooseAndAssign.chooseSchoolObject(theSchool.getSchoolStudents());
		if (st == null) {
			return;
		}
		System.out.println("LIST OF ALL THE ASSIGNMENTS OF STUDENT:" + st.getFirstName() + " " + st.getLastName() + " \n*****************");
	

		for (StudentAssignment sta : st.getStudentAssignments()) {

			System.out.println(sta.getAssignment());

		}
		if (st.getStudentAssignments().isEmpty()) {
			System.out.println("No Assignments found");
		}
	}

	public static void displayStudentsMoreThanOneCourse(PrivateSchool theSchool) {
		System.out.println("LIST OF ALL THE STUDENTS WITH MORE THAN ONE COURSE\n****************");
		theSchool.getSchoolStudents().stream().filter(st -> st.getAttendedClassRooms().size() > 1).forEach(s -> System.out.println(s));

	}

	public static void displayStudentsWithAssignmentInWeek(PrivateSchool theSchool) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  date to check  yyyy-MM-dd(e.g.2020-05-28)");

		LocalDate inputDate = Validator.loopAndGetValidDate(sc, s -> true);
		int weekDayValue = inputDate.getDayOfWeek().getValue();
		LocalDate startDate = inputDate.minusDays(weekDayValue);

		LocalDate endDate = startDate.plusDays(6);
		System.out.println("LIST OF ALL THE STUDENTS WITH ASSIGNMENT WITHIN SPECIFIC WEEK\n****************");
		for (Student st : theSchool.getSchoolStudents()) {
			for (StudentAssignment sa : st.getStudentAssignments()) {
				if (sa.getAssignment().getDeadLine().isAfter(startDate) && sa.getAssignment().getDeadLine().isBefore(endDate)) {
					System.out.println(st);
					break;
				}

			}

		}

	}


	
}
