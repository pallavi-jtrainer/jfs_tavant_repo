package com.tavant.hibernate.HibernateBatchProcessingDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateBatchProcessingDemo.entity.Student;
import com.tavant.hibernate.HibernateBatchProcessingDemo.utils.HibernateUtil;

public class StudentDao {
	public void batchInsertStudents(List<Student> students) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
//			int len = students.size();
			int i = 0;
			
			for(Student s: students) {
				session.persist(s);
				
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
				
				i++;
				
			}
			tx.commit();
		}catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<Student> listAllStudents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction tx = null;
		
		List<Student> students = session.createQuery("from Student", Student.class).list();
		session.close();
		return students;
		
	}
}
