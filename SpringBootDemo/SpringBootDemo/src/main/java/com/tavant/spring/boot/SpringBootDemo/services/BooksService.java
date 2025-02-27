package com.tavant.spring.boot.SpringBootDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.SpringBootDemo.entity.Books;
import com.tavant.spring.boot.SpringBootDemo.repository.BooksRepository;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

@Service
public class BooksService {

	@Autowired
	private BooksRepository repo;
	
	public List<Books> listAllBooks() {
		return repo.findAll();
	}
	
	public Books getBookById(int id) {
		return repo.findByBookId(id);
	}
	
	public List<Books> listAllByTitle(String title) {
		return repo.findAllByTitle(title);
	}
	
	public List<Books> listAllByAuthor(String author) {
		return repo.findAllByAuthor(author);
	}
	
	public Books saveBookDetails(Books book) {
		return repo.save(book);
	}
	
	@Transactional
	public String updateBookPrice(int id, double price) {
		String str = "Unable to update book";
		
		int res = repo.updateBookPrice(id, price);
		
		if(res > 0) {
			str = "Book price updated successfully";
		}
		
		return str;
	}
	
	@Transactional
	public void deleteBook(int id) {
		repo.deleteByBookId(id);
	}
}
