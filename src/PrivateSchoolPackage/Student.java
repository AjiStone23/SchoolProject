/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.time.LocalDate;
import java.util.HashSet;

/**
 *
 * @author ajist
 */
public class Student extends Person {

	private float tuitionFees;
	private HashSet<ClassRoom> attendedClassRooms;
	private HashSet<StudentAssignment> studentAssignments;

	public Student(String firstName, String lastName, LocalDate dateofBirth) {

		super(firstName, lastName, dateofBirth);
		this.attendedClassRooms = new HashSet<>();
		this.studentAssignments = new HashSet<>();
	}

	public Student(String firstName, String lastName, LocalDate dateOfBirth, int personId, float tuitionFees) {
		super(firstName, lastName, dateOfBirth, personId);
		this.tuitionFees = tuitionFees;
	}

	public float getTuitionFees() {
		return tuitionFees;
	}

	public void setTuitionFees(float tuitionFees) {
		this.tuitionFees = tuitionFees;
	}

	public HashSet<ClassRoom> getAttendedClassRooms() {
		return attendedClassRooms;
	}

	public void setAttendedClassRooms(HashSet<ClassRoom> attendedClassRooms) {
		this.attendedClassRooms = attendedClassRooms;
	}

	public HashSet<StudentAssignment> getStudentAssignments() {
		return studentAssignments;
	}

	public void setStudentAssignments(HashSet<StudentAssignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public boolean attendClassRoom(ClassRoom classroom) {
		boolean b = classroom.getStudents().add(this);
		if (b) {
			for (CourseAssignment ass : classroom.getTheCourse().getCourseAssignments()) {
				StudentAssignment stAss = new StudentAssignment(ass);
				this.studentAssignments.add(stAss);

			}
			this.attendedClassRooms.add(classroom);
			return b;
		}
		return b;

	}

	public void updateAssignments(CourseAssignment ca) {
		StudentAssignment stAss = new StudentAssignment(ca);
		this.studentAssignments.add(stAss);
	}

}
