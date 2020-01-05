/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ajist
 */
public abstract  class Person implements IschoolObject {
	
private	String firstName;
private	String lastName;
private	LocalDate dateofBirth;
private   int personCode;
	
	public Person(String firstName, String lastName, LocalDate dateofBirth) {
		
		this.firstName = firstName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.dateofBirth = dateofBirth;
		this.personCode= this.hashCode();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

@Override
	public int getSchoolObjectCode() {
		return personCode;
	}

	public void setPersonCode(int personCode) {
		this.personCode = personCode;
	}

	
	
	
	
	@Override
	public final int hashCode() {
		int hash = 7;
		hash = 83 * hash + Objects.hashCode(this.firstName);
		hash = 83 * hash + Objects.hashCode(this.lastName);
		hash = 83 * hash + Objects.hashCode(this.dateofBirth);
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
		final Person other = (Person) obj;
		if (!Objects.equals(this.firstName, other.firstName)) {
			return false;
		}
		if (!Objects.equals(this.lastName, other.lastName)) {
			return false;
		}
		if (!Objects.equals(this.dateofBirth, other.dateofBirth)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"{firstName=" + firstName + ", lastName=" + lastName + ", dateofBirth=" + dateofBirth + ", personCode=" + personCode + '}';
	}
	
	
	
	
	
	
}
