package com.tavant.hibernate.HibernateOneToOneMapping.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.tavant.hibernate.HibernateOneToOneMapping.entity.Product;
import com.tavant.hibernate.HibernateOneToOneMapping.entity.ProductDetails;

public class HibernateUtil {

private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				//configuration object
				Configuration config = new Configuration();
				
				//properties similar to hibernate.cfg.xml
				Properties properties = new Properties();
				properties.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/sampledb");
				properties.put(Environment.JAKARTA_JDBC_USER, "root");
				properties.put(Environment.JAKARTA_JDBC_PASSWORD, "Pass1234");
				
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				
				//accessing the properties in the config object
				config.setProperties(properties);
				
				//mapping the entity class to the configurations
				config.addAnnotatedClass(Product.class);
				config.addAnnotatedClass(ProductDetails.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties()).build();
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		return sessionFactory;

	}

}
