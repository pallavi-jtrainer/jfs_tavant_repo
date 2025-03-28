package com.tavant.spring.boot.SpringBootDemo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksTest {
	
	Books b = null;
	
	@BeforeEach
	public void createBook() {
		b = new Books();
	}

	@AfterEach
	public void destroyBook() {
		b = null;
	}
	/**
	 * Testing the default constructor
	 */
	@Test
	public void testBooks() {
//		Books book = new Books();
		
		b.setBookId(1);
		b.setTitle("Testing SpringBoot");
		b.setAuthor("Unknown");
		b.setReleaseYear(2025);
		b.setPrice(230.00);
		
		assertEquals(1, b.getBookId());
		assertEquals("Testing SpringBoot", b.getTitle());
		assertEquals(230.00, b.getPrice());
	}
	
	/**
	 * testing a parameterized constructor
	 */
	@Test
	public void testBooks1() {
		Books book = new Books("Testing SpringBoot", "Unknown", 2025, 230.00);
		
		assertEquals(new Books("Testing SpringBoot", "Unknown", 2025, 230.00), book);
	}
}
