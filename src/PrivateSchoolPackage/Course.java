/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author ajist
 */
public class Course {

	private String courseTitle;
	private LocalDate start_Date;
	private LocalDate end_Date;
	private HashSet<CourseAssignment> courseAssignments;
	private HashSet< Stream> streams;
	private TimeType timetype;
	private int courseId;

	public Course(String courseTitle, LocalDate start_Date, LocalDate end_Date, int courseId) {
		this.courseTitle = courseTitle;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.courseId = courseId;
	}

	public Course(String title, LocalDate start_Date, LocalDate end_Date) {
		this.courseTitle = title;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.courseAssignments = new HashSet<>();
		this.streams = new HashSet<>();

	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public LocalDate getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(LocalDate start_Date) {
		this.start_Date = start_Date;
	}

	public LocalDate getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(LocalDate end_Date) {
		this.end_Date = end_Date;
	}

	public HashSet<CourseAssignment> getCourseAssignments() {
		return courseAssignments;
	}

	public void setCourseAssignments(HashSet<CourseAssignment> courseAssignments) {
		this.courseAssignments = courseAssignments;
	}

	public HashSet<Stream> getStreams() {
		return streams;
	}

	public void setStreams(HashSet<Stream> streams) {
		this.streams = streams;
	}

	public TimeType getTimetype() {
		return timetype;
	}

	public void setTimetype(TimeType timetype) {
		this.timetype = timetype;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.courseTitle);
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
		final Course other = (Course) obj;
		if (!Objects.equals(this.courseTitle, other.courseTitle)) {
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		return "Course{" + "courseTitle=" + courseTitle + ", start_Date=" + start_Date + ", end_Date=" + end_Date + ", timetype=" + timetype + ", courseId=" + courseId + '}';
	}

	public boolean addToStream(Stream stream) {

		boolean b = stream.getStreamCourses().add(this);
		this.streams.add(stream);
		return b;

	}

	public boolean addAssignment(CourseAssignment assignment, HashSet<ClassRoom> classrooms) {
		return assignment.addToCourse(this, classrooms);

	}

	public int getCourseId() {
		return courseId;
	}

}
