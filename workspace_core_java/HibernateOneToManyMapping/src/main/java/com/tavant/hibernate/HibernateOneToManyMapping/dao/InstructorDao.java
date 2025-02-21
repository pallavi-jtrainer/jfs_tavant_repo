package com.tavant.hibernate.HibernateOneToManyMapping.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateOneToManyMapping.entity.Instructor;
import com.tavant.hibernate.HibernateOneToManyMapping.utils.HibernateUtil;

public class InstructorDao {

	public void saveInstructor(Instructor instructor) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(instructor);
			transaction.commit();
		} catch(Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
			System.out.println(e.getMessage());
		}
	}
	
	public Instructor getInstructorDetails(int id) {
//		Transaction transaction = null;
		Instructor instructor = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			instructor = session.get(Instructor.class, id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return instructor;
	}
	
	public void updateInstructorDetails(Instructor instructor) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(instructor);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
}
