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
public class ClassRoom {

	private String classRoomTitle;
	private Course theCourse;
	private HashSet<Student> students;
	private HashSet<Trainer> trainers;
	private int ClassRoomId;

	public ClassRoom(String classRoomTitle, int ClassRoomId) {
		this.classRoomTitle = classRoomTitle;
		this.ClassRoomId = ClassRoomId;
	}

	public ClassRoom(String classRoomTitle) {
		this.classRoomTitle = classRoomTitle;
	}

	public ClassRoom(String title, Course theCourse) {
		this.classRoomTitle = title;
		this.theCourse = theCourse;
		this.students = new HashSet<>();
		this.trainers = new HashSet<>();

	}

	public String getClassRoomTitle() {
		return classRoomTitle;
	}

	public void setClassRoomTitle(String classRoomTitle) {
		this.classRoomTitle = classRoomTitle;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	public HashSet<Student> getStudents() {
		return students;
	}

	public void setStudents(HashSet<Student> students) {
		this.students = students;
	}

	public HashSet<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(HashSet<Trainer> trainers) {
		this.trainers = trainers;
	}

	public boolean addStudent(Student st) {
		return st.attendClassRoom(this);
	}

	public boolean addTrainer(Trainer tr) {
		return tr.assignClassRoom(this);
	}

	public int getClassRoomId() {
		return ClassRoomId;
	}

	@Override
	public String toString() {
		return "ClassRoom{" + "classRoomTitle=" + classRoomTitle + ", ClassRoomId=" + ClassRoomId + '}';
	}

}
