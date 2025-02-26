package com.tavant.spring.mvc.SpringMvcDemo.dao;

import java.util.List;

import com.tavant.spring.mvc.SpringMvcDemo.entity.Faculty;


public interface FacultyDao {

	public List<Faculty> listAll();
	public void saveFaculty(Faculty faculty);
	public Faculty getFacultyById(int id);
	public Faculty getFacultyByEmail(String email);
	public void updateFaculty(Faculty facutly);
}
