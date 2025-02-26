package com.tavant.spring.mvc.SpringMvcDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tavant.spring.mvc.SpringMvcDemo.entity.Faculty;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class FacultyDaoImpl implements FacultyDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Faculty> listAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Faculty> query = cb.createQuery(Faculty.class);
		Root<Faculty> root = query.from(Faculty.class);
		query.select(root); // select * from Faculty
		
		Query q = session.createQuery(query); // fires the query
		return q.getResultList();
	}

	@Override
	public void saveFaculty(Faculty faculty) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.persist(faculty);
	}

	@Override
	public Faculty getFacultyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty f = session.byId(Faculty.class).load(id);
		return f;
	}

	@Override
	public Faculty getFacultyByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Faculty f = session.get(Faculty.class, email);
		return f;
	}

	@Override
	public void updateFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(faculty);
	}

}
