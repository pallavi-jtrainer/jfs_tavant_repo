package com.tavant.hibernate.HibernateCrudWithJavaConfig;

import com.tavant.hibernate.HibernateCrudWithJavaConfig.dao.BooksDao;
import com.tavant.hibernate.HibernateCrudWithJavaConfig.entity.Books;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BooksDao dao = new BooksDao();
//        Books book = new Books(101, "Coding with Java", "Unknown", 230.00);
        
//        dao.saveBookDetails(book);
        try {
	        Books b = dao.getBookById(102);
	        System.out.println(b.toString());
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
    }
}
