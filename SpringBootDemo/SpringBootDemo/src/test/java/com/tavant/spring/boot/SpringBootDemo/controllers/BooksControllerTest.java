package com.tavant.spring.boot.SpringBootDemo.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.willDoNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tavant.spring.boot.SpringBootDemo.entity.Books;
import com.tavant.spring.boot.SpringBootDemo.services.BooksService;


@WebMvcTest(BooksController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BooksControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private BooksService booksService;
	
	@Autowired
	private ObjectMapper mapper;
	
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
	
	/**
	 * test for Postmapping
	 * @throws Exception 
	 * @throws JsonProcessingException 
	 */
	@Test
	@Order(1)
	public void testSaveBookDetails() throws JsonProcessingException, Exception {
		given(booksService.saveBookDetails(book)).willReturn(book);
		
		ResultActions result = mockMvc.perform(post("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(book)));
		
		result.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title", is(book.getTitle())))
			.andExpect(jsonPath("$.author", is(book.getAuthor())))
			.andExpect(jsonPath("$.releaseYear", is(book.getReleaseYear())))
			.andExpect(jsonPath("$.price", is(book.getPrice())));		
			
	}
	
	/**
	 * getmapping for getting a single book details
	 * @throws Exception 
	 */
	@Test
	@Order(2)
	public void testRetrieveBook() throws Exception {
		given(booksService.getBookById(book.getBookId())).willReturn(book);
		
		ResultActions result = mockMvc.perform(get("/books/{id}", book.getBookId()));
		
		result.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.title", is(book.getTitle())))
			.andExpect(jsonPath("$.author", is(book.getAuthor())))
			.andExpect(jsonPath("$.releaseYear", is(book.getReleaseYear())))
			.andExpect(jsonPath("$.price", is(book.getPrice())));
	}
	
	/**
	 * getmapping for getting all books
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void testListAllBooks() throws Exception {
		//Mock database
		List<Books> bookList = new ArrayList<Books>();
		
		Books b1 = new Books("Mockito in SpringBoot", "Unknown", 2024, 230.00);
		b1.setBookId(2);
		Books b2 = new Books("JUnit with Mockito", "Unknown", 2025, 300.00);
		b2.setBookId(3);
		Books b3 = new Books("SpringBoot DI", "Unknown", 2024, 150.00);
		b3.setBookId(4);
		
		bookList.add(book);
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		
		given(booksService.listAllBooks()).willReturn(bookList);
		
		ResultActions result = mockMvc.perform(get("/books"));
		
		result.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.size()", is(bookList.size())));
	}
	
	/**
	 * patchmapping for updating price of book
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	@Order(4)
	public void testUpdatePrice() throws JsonProcessingException, Exception {
		given(booksService.getBookById(book.getBookId())).willReturn(book);
		
		book.setPrice(250.00);
		given(booksService.updateBookPrice(book.getBookId(), book.getPrice()))
			.willReturn("Book price updated successfully");
		
		ResultActions result = mockMvc.perform(patch("/books/update/{id}/{price}", 
				book.getBookId(), book.getPrice())
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(book)));
		
		result.andDo(print())
			.andExpect(status().isOk());
//			.andExpect(jsonPath("$.title", is(book.getTitle())))
//			.andExpect(jsonPath("$.author", is(book.getAuthor())))
//			.andExpect(jsonPath("$.releaseYear", is(book.getReleaseYear())))
//			.andExpect(jsonPath("$.price", is(book.getPrice())));
	}
	
	/**
	 * deletemapping to delete a book
	 * @throws Exception
	 */
	@Test
	@Order(5)
	public void testDeleteBook() throws Exception {
		willDoNothing().given(booksService).deleteBook(book.getBookId());
		
		ResultActions result = mockMvc.perform(delete("/books/delete/{id}", book.getBookId()));
		
		result.andDo(print())
		.andExpect(status().isOk());
	}
}
