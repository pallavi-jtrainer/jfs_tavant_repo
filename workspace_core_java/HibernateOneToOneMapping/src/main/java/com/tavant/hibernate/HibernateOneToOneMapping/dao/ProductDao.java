package com.tavant.hibernate.HibernateOneToOneMapping.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateOneToOneMapping.entity.Product;
import com.tavant.hibernate.HibernateOneToOneMapping.utils.HibernateUtil;

public class ProductDao {
	public void saveProduct(Product product) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(product);
			transaction.commit();
		}catch(Exception ex) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			System.out.println(ex.getMessage());
		}
	}
	
	public Product getProductById(int id) {
		Product p = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			p = session.createQuery("from Product p where p.productId = " + id, Product.class).getSingleResult();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public void updateProduct(Product product) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(product);
			transaction.commit();
		}catch(Exception ex) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			System.out.println(ex.getMessage());
		}
	}
	
	public void deleteProduct(int id) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Product p = session.get(Product.class, id);
			
			if(p != null) {
				session.remove(p);
			} else {
				System.out.println("Product not found");
			}
			
			transaction.commit();
		}catch(Exception ex) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			System.out.println(ex.getMessage());
		}
	}
}
