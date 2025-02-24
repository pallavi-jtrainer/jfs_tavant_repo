package com.tavant.hibernate.HibernateCachingDemo.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateCachingDemo.entity.Users;
import com.tavant.hibernate.HibernateCachingDemo.utils.HibernateUtil;

public class UsersService {
	public void createUser(Users user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
	}
	
	public void firstLevelCachingDemo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Load user for the first time
            Users user1 = session.get(Users.class, 1);
            System.out.println("First query: " + user1.getFirstName());

            // Load user again within the same session
            Users user2 = session.get(Users.class, 1);
            System.out.println("Second query: " + user2.getFirstName());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
	public void secondLevelCacheDemo() {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction1 = null;

        try {
            transaction1 = session1.beginTransaction();

            // Load user for the first time
            Users user1 = session1.get(Users.class, 1);
            System.out.println("First session, first query: " + user1.getEmail());

            transaction1.commit();
        } catch (Exception e) {
            if (transaction1 != null) {
                transaction1.rollback();
            }
            e.printStackTrace();
        } finally {
            session1.close();
        }

        // Open a new session and load the same user
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction2 = null;

        try {
            transaction2 = session2.beginTransaction();

            // Load user again in a new session
            Users user2 = session2.get(Users.class, 1);
            System.out.println("Second session, first query: " + user2.getEmail());

            transaction2.commit();
        } catch (Exception e) {
            if (transaction2 != null) {
                transaction2.rollback();
            }
            e.printStackTrace();
        } finally {
            session2.close();
        }
    }
}
