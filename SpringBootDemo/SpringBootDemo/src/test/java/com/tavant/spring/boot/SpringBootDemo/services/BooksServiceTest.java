package com.tavant.spring.boot.SpringBootDemo.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tavant.spring.boot.SpringBootDemo.entity.Books;
import com.tavant.spring.boot.SpringBootDemo.exceptions.ObjectMalformedException;
import com.tavant.spring.boot.SpringBootDemo.exceptions.ResourceNotfoundException;
import com.tavant.spring.boot.SpringBootDemo.repository.BooksRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BooksServiceTest {

	@Mock
	private BooksRepository booksRepository;
	
	@InjectMocks
	private BooksService booksService;
	
	private Books book;
	
	@BeforeEach
	public void setUp() {
		book = new Books("Springboot testing", "Unknown", 2024, 200.00);
		book.setBookId(1);
	}
	
	@AfterEach
	public void tearDown() {
		book = null;
	}
	
	@Test
	@Order(1)
	public void testSaveBookDetails() throws ObjectMalformedException {
		//pre-condition
		given(booksRepository.save(book)).willReturn(book);
		
		//action
		Books b = booksService.saveBookDetails(book);
		
		//verification
		System.out.println(b.toString());
		assertThat(b).isNotNull();
	}
	
	@Test
	@Order(2)
	public void testGetBookById() throws ResourceNotfoundException {
		given(booksRepository.findByBookId(book.getBookId())).willReturn(book);
		
		Books b = booksService.getBookById(book.getBookId());
		
		System.out.println(b);
		assertThat(b).isNotNull();
	}
	
	@Test
	@Order(3)
	public void testListAllBooks() {
		Books b = new Books("Unit Testing in SpringBoot", "Unknown", 2023, 300.00);
		b.setBookId(2);

		given(booksRepository.findAll()).willReturn(List.of(book, b));
		
		List<Books> bookList = booksService.listAllBooks();
		
		System.out.println(bookList);
		assertThat(bookList).isNotNull();
		assertThat(bookList.size()).isGreaterThan(1);
	}
	
	@Test
	@Order(4)
	public void testUpdateBookPrice() {
//		given(booksRepository.findByBookId(book.getBookId())).willReturn(book);
		
		book.setPrice(250.00);
		given(booksRepository.updateBookPrice(book.getBookId(), book.getPrice())).willReturn(1);
		
		String str = booksService.updateBookPrice(book.getBookId(), book.getPrice());
		
		System.out.println(str);
		assertThat(book.getPrice()).isEqualTo(250.00);
	}
	
	@Test
	@Order(5)
	public void testDeleteBook() {
		willDoNothing().given(booksRepository).deleteByBookId(book.getBookId());
		
		booksService.deleteBook(book.getBookId());
		
		verify(booksRepository, times(1)).deleteByBookId(book.getBookId());
	}
}
