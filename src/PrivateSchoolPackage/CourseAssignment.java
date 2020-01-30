/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author ajist
 */
public class CourseAssignment {

	private String title;
	private String description;
	private LocalDate deadLine;
	private int maxOralMark;
	private int maxTotalMark;
	private int CourseAssignmentId;

	public CourseAssignment(String title, String description, LocalDate deadLine, int maxOralMark, int maxTotalMark, int CourseAssignmentId) {
		this.title = title;
		this.description = description;
		this.deadLine = deadLine;
		this.maxOralMark = maxOralMark;
		this.maxTotalMark = maxTotalMark;
		this.CourseAssignmentId = CourseAssignmentId;
	}

	public CourseAssignment(String title, LocalDate deadLine) {
		this.title = title;
		this.deadLine = deadLine;
		this.maxOralMark = 20;
		this.maxTotalMark = 100;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		this.deadLine = deadLine;
	}

	public int getMaxOralMark() {
		return maxOralMark;
	}

	public void setMaxOralMark(int maxOralMark) {
		this.maxOralMark = maxOralMark;
	}

	public int getMaxTotalMark() {
		return maxTotalMark;
	}

	public void setMaxTotalMark(int maxTotalMark) {
		this.maxTotalMark = maxTotalMark;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + Objects.hashCode(this.title);
		hash = 89 * hash + Objects.hashCode(this.deadLine);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CourseAssignment other = (CourseAssignment) obj;
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		if (!Objects.equals(this.deadLine, other.deadLine)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CourseAssignment{" + "title=" + title + ", deadLine=" + deadLine + ", maxOralMark=" + maxOralMark + ", maxTotalMark=" + maxTotalMark + ", CourseAssignmentCode=" + CourseAssignmentId + '}';
	}

	public boolean addToCourse(Course course, HashSet<ClassRoom> classrooms) {

		for (ClassRoom room : classrooms) {
			if (room.getTheCourse().equals(course)) {
				for (Student st : room.getStudents()) {
					st.updateAssignments(this);

				}
			}

		}
		return course.getCourseAssignments().add(this);
	}

	public int getCourseAssignmentId() {
		return CourseAssignmentId;
	}

}
