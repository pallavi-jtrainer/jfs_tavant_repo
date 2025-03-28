package com.tavant.spring.mvc.SpringMvcDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.mvc.SpringMvcDemo.dao.FacultyDao;
import com.tavant.spring.mvc.SpringMvcDemo.entity.Faculty;

import jakarta.transaction.Transactional;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyDao dao;
	
	@Transactional
	public List<Faculty> listAll() {
		return dao.listAll();
	}
	
	@Transactional
	public Faculty getFacultyById(int id) {
		return dao.getFacultyById(id);
	}
	
	@Transactional
	public Faculty getFacultyByEmail(String email) {
		return dao.getFacultyByEmail(email);
	}
	
	@Transactional
	public void saveFaculty(Faculty faculty) {
		dao.saveFaculty(faculty);
	}
	
	@Transactional
	public void updateFaculty(Faculty faculty) {
		dao.updateFaculty(faculty);
	}
}
