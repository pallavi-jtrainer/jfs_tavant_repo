package com.tavant.hibernate.HibernateOneToOneMapping.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tavant.hibernate.HibernateOneToOneMapping.entity.Product;
import com.tavant.hibernate.HibernateOneToOneMapping.entity.ProductDetails;
import com.tavant.hibernate.HibernateOneToOneMapping.utils.HibernateUtil;

public class ProductDetailsDao {

	public void saveProductDetails(ProductDetails details) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(details);
			transaction.commit();
		}catch(Exception ex) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			System.out.println(ex.getMessage());
		}
	}
	
	public void updateProductDetails(ProductDetails details) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(details);
			transaction.commit();
		}catch(Exception ex) {
			if(transaction !=null) {
				transaction.rollback();
			}
			
			System.out.println(ex.getMessage());
		}
	}
	
	public ProductDetails getProductDetails(int id) {
		ProductDetails p = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			p = session.createQuery("from ProductDetails p where p.detailsId = " + id, ProductDetails.class).getSingleResult();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
}
