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
public class Stream implements IschoolObject{

	private String streamTitle;

	private HashSet<Course> streamCourses;
    private int StreamCode;
	
	public Stream(String streamTitle) {
		this.streamTitle = streamTitle;
		this.streamCourses = new HashSet<>();
		this.StreamCode=this.hashCode();
	}

	public String getStreamTitle() {
		return streamTitle;
	}

	public void setStreamTitle(String streamTitle) {
		this.streamTitle = streamTitle;
	}

	public HashSet<Course> getStreamCourses() {
		return streamCourses;
	}

	public void setStreamCourses(HashSet<Course> streamCourses) {
		this.streamCourses = streamCourses;
	}

	public boolean addCourse(Course course) {
		return course.addToStream(this);

	}

	public int getSchoolObjectCode() {
		return StreamCode;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.streamTitle);
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
		final Stream other = (Stream) obj;
		if (!Objects.equals(this.streamTitle, other.streamTitle)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stream{" + "streamTitle=" + streamTitle + ", streamCourses=" + streamCourses + '}';
	}
	

}
