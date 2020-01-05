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
public class Course implements IschoolObject{

	private String title;
	private LocalDate start_Date;
	private LocalDate end_Date;
	private HashSet<CourseAssignment> courseAssignments;
	private HashSet< Stream> streams;
	private TimeType timetype;
	private int CourseCode;

	public Course(String title, LocalDate start_Date, LocalDate end_Date) {
		this.title = title;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.courseAssignments = new HashSet<>();
		this.streams = new HashSet<>();
		this.CourseCode= this.hashCode();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	public int getSchoolObjectCode() {
		return CourseCode;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.title);
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
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		
		Iterator<Stream> it = streams.iterator();
		ArrayList<String> streamNames= new ArrayList<>();
     while(it.hasNext()){
        streamNames.add(it.next().getStreamTitle());
     }
		return "Course{" + "title=" + title + ", start_Date=" + start_Date + ", end_Date=" + end_Date + ", streams=" + streamNames + ", timetype=" + timetype + ", CourseCode=" + CourseCode + '}';
	}
	

	public boolean addToStream(Stream stream) {

		boolean b = stream.getStreamCourses().add(this);
		this.streams.add(stream);
		return b;

	}

	public boolean addAssignment(CourseAssignment assignment,HashSet<ClassRoom> classrooms) {
		return assignment.addToCourse(this,classrooms);

	}

}
