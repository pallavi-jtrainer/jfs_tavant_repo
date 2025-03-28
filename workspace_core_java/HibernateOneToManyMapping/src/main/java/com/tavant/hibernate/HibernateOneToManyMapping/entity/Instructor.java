package com.tavant.hibernate.HibernateOneToManyMapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;
	
	@Column(name="instructor_name", nullable=false)
	private String instructorName;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@OneToMany(mappedBy="instructor", cascade = { 
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.DETACH,
		    CascadeType.REFRESH })
	private List<Course> courses = new ArrayList<Course>();
	
	public Instructor() {}

	public Instructor(String instructorName, String email) {
		this.instructorName = instructorName;
		this.email = email;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", instructorName=" 
				+ instructorName + ", email=" + email 
				+ "Courses: "+ courses + "]";
	}
	
	
}
