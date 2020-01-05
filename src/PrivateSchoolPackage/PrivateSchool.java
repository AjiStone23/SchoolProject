/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.util.HashSet;

/**
 *
 * @author ajist
 */
public class PrivateSchool {

	String schoolName;

private	HashSet<Person> schoolPopulation;
private	HashSet<Student> schoolStudents;
private	HashSet<Trainer> schoolTrainers;
private	HashSet<Course> schoolCourses;
private	HashSet<ClassRoom> schoolClassrooms;
private  HashSet<Stream> schoolStreams;
private  HashSet<CourseAssignment> assignments;

	public PrivateSchool(String schoolName) {
		this.schoolName = schoolName;
		this.schoolClassrooms = new HashSet<>();
		this.schoolCourses = new HashSet<>();
		this.schoolPopulation = new HashSet<>();
		this.schoolStudents = new HashSet<>();
		this.schoolTrainers = new HashSet<>();
        this.schoolStreams= new HashSet<>();
		this.assignments= new HashSet<>();
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public HashSet<Person> getSchoolPopulation() {
		return schoolPopulation;
	}

	public void setSchoolPopulation(HashSet<Person> schoolPopulation) {
		this.schoolPopulation = schoolPopulation;
	}

	public HashSet<Student> getSchoolStudents() {
		return schoolStudents;
	}

	public HashSet<CourseAssignment> getAssignments() {
		return assignments;
	}
	

	public void setSchoolStudents(HashSet<Student> schoolStudents) {
		this.schoolStudents = schoolStudents;
	}

	public HashSet<Trainer> getSchoolTrainers() {
		return schoolTrainers;
	}

	public void setSchoolTrainers(HashSet<Trainer> schoolTrainers) {
		this.schoolTrainers = schoolTrainers;
	}

	public HashSet<Course> getSchoolCourses() {
		return schoolCourses;
	}

	public void setSchoolCourses(HashSet<Course> schoolCourses) {
		this.schoolCourses = schoolCourses;
	}

	public HashSet<ClassRoom> getSchoolClassrooms() {
		return schoolClassrooms;
	}

	public void setSchoolClassrooms(HashSet<ClassRoom> schoolClassrooms) {
		this.schoolClassrooms = schoolClassrooms;
	}

	public HashSet<Stream> getSchoolStreams() {
		return schoolStreams;
	}

	public void setSchoolStreams(HashSet<Stream> schoolStreams) {
		this.schoolStreams = schoolStreams;
	}
	
	
	
	
	

}
