/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author ajist
 */
public class ClassRoom  implements IschoolObject{
	
private	String title;
private	Course theCourse;
private	HashSet<Student> students;
private	HashSet<Trainer> trainers;
private  int ClassroomCode;

	public ClassRoom(String title, Course theCourse) {
		this.title = title;
		this.theCourse = theCourse;
		this.students=new HashSet<>();
		this.trainers=new HashSet<>();
		this.ClassroomCode= this.hashCode();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getSchoolObjectCode() {
		return ClassroomCode;
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
	
	public boolean addStudent(Student st){
		return st.attendClassRoom(this);
	}
	public boolean addTrainer(Trainer tr){
		return tr.assignClassRoom(this);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 67 * hash + Objects.hashCode(this.title);
		hash = 67 * hash + Objects.hashCode(this.theCourse);
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
		final ClassRoom other = (ClassRoom) obj;
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		if (!Objects.equals(this.theCourse, other.theCourse)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ClassRoom{" + "title=" + title + ", theCourse=" + theCourse.getTitle() + ", ClassroomCode=" + ClassroomCode + '}';
	}
	
	
}
