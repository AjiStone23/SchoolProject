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
public class Trainer extends Person implements IschoolObject{

private	HashSet<ClassRoom> assignedClassRooms;
private	Subject subject;

	
	public Trainer(String firstName, String lastName, LocalDate dateofBirth) {

		super(firstName, lastName, dateofBirth);
		this.assignedClassRooms = new HashSet<>();
        
	}

	public HashSet<ClassRoom> getAssignedClasses() {
		return assignedClassRooms;
	}

	public void setAssignedClasses(HashSet<ClassRoom> assignedClasses) {
		this.assignedClassRooms = assignedClasses;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public boolean assignClassRoom(ClassRoom classroom){
		
		this.assignedClassRooms.add(classroom);
		return classroom.getTrainers().add(this);
		
		
	}

}
