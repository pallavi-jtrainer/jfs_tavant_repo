package com.tavant.hibernate.HibernateCrudWithJavaConfig.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateCrudWithJavaConfig.entity.Books;
import com.tavant.hibernate.HibernateCrudWithJavaConfig.utils.HibernateUtils;

public class BooksDao {

	public void saveBookDetails(Books book) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(book);
			transaction.commit();
			session.close();
		} catch (Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println(ex.getMessage());
		}
	}
	
	public List<Books> listAllBooks() {
		List<Books> books = new ArrayList<Books>();
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			books = session.createQuery("from Books", Books.class).list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return books;
	}
	
	public Books getBookById(int id) throws Exception{
//		Books book = null;
//		try(Session session = HibernateUtils.getSessionFactory().openSession()){
//			book = session.createQuery("from Books b where b.bookId = " + id, Books.class).getSingleResult();		
//		}catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		return book;
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from Books b where b.bookId = " + id, Books.class).getSingleResult();
		
	}
	
}
