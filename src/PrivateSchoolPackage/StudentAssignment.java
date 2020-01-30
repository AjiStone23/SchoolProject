/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrivateSchoolPackage;

import java.time.LocalDate;

/**
 *
 * @author ajist
 */
public class StudentAssignment {

	private final CourseAssignment assignment;
	private boolean submited;
	private LocalDate subDateTime;
	private int oralMark;
	private int totalMark;

	public StudentAssignment(CourseAssignment assignment) {
		this.assignment = assignment;
	}

	public void submitAssignment() {

		LocalDate now = LocalDate.now();
		if (this.assignment.getDeadLine().compareTo(now) >= 0) {
			this.submited = true;
			this.subDateTime = now;
		}

	}

	public CourseAssignment getAssignment() {
		return assignment;
	}

	public boolean isSubmited() {
		return submited;
	}

	public void setSubmited(boolean submited) {
		this.submited = submited;
	}

	public int getOralMark() {
		return oralMark;
	}

	public boolean setOralMark(int oralMark) {
		if (submited) {
			if (oralMark >= 0 && oralMark <= this.assignment.getMaxOralMark()) {
				this.oralMark = oralMark;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public int getTotalMark() {
		return totalMark;
	}

	public boolean setTotalMark(int totalMark) {
		if (totalMark >= 0 && totalMark <= this.assignment.getMaxTotalMark()) {
			this.totalMark = totalMark;
			return true;
		} else {
			return false;
		}
	}

	public LocalDate getSubDateTime() {
		return subDateTime;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 31 * hash + this.assignment.hashCode();
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
		final StudentAssignment other = (StudentAssignment) obj;
		if (!this.assignment.equals(other.assignment)) {
			return false;
		}
		return true;
	}

}
