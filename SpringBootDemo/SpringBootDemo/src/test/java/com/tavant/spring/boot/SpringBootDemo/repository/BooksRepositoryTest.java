package com.tavant.spring.boot.SpringBootDemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.tavant.spring.boot.SpringBootDemo.entity.Books;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BooksRepositoryTest {
	
	@Autowired
	private BooksRepository repo;
	
	@Test
	@Order(1)
	@DisplayName("Test 1: Save Books test")
	@Rollback(value = false)
	public void testSaveBookDetails() {
		//action
		Books book = new Books("Testing SpringBoot", "Unknown", 2025, 230.00);
		
		Books b = repo.save(book);
		
		Assertions.assertThat(b.getBookId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testFindByBookId() {
		Books b = repo.findByBookId(1);
		
		System.out.println(b.toString());
		
		Assertions.assertThat(b.getBookId()).isEqualTo(1);
	}
}
