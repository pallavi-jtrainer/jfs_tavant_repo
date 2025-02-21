package com.tavant.hibernate.HibernateOneToManyMapping.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateOneToManyMapping.entity.Course;
import com.tavant.hibernate.HibernateOneToManyMapping.utils.HibernateUtil;

public class CourseDao {

	public void saveCourse(Course course) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(course);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
	public void updateCourseDetails(Course course) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(course);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
	public List<Course> listAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			courses = session.createQuery("from Course", Course.class).list();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return courses;
	}
	
	public void deleteCourse(int id) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Course course = session.get(Course.class, id);
			if (course != null) {
				session.remove(course);
			} else
				System.out.println("Course not found");
			
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
	public Course getCourseDetails(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course c = session.get(Course.class, id);
		return c;
	}
}
