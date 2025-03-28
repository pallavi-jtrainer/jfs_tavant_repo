package com.tavant.spring.mvc.SpringMvcDemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	private Environment envt;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {
				"com.tavant.spring.mvc.SpringMvcDemo.entity"
		});
		
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(envt.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(envt.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(envt.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(envt.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", envt.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", envt.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", envt.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", envt.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory().getObject());
		
		return tx;
	}
}






