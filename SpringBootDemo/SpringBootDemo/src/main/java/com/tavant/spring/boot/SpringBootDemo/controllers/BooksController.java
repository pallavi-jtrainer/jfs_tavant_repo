package com.tavant.spring.boot.SpringBootDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.SpringBootDemo.entity.Books;
import com.tavant.spring.boot.SpringBootDemo.exceptions.ObjectMalformedException;
import com.tavant.spring.boot.SpringBootDemo.exceptions.ResourceNotfoundException;
import com.tavant.spring.boot.SpringBootDemo.services.BooksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="Books", description = "Books API")
//@Controller
@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BooksService service;
	
	/*
	 * Controller APIs for Thymeleaf
	 */
//	@GetMapping
//	public String listAllBooks(Model model) {
//		model.addAttribute("books", service.listAllBooks());
//		return "index";
//	}
//	
//	@GetMapping("show")
//	public String showForm(Model model) {
//		model.addAttribute("book", new Books());
//		return "add-book";
//	}
//	
//	@PostMapping("add")
//	public String addNewBook(@ModelAttribute Books book) {
//		try {
//			Books b = service.saveBookDetails(book);
//		} catch (ObjectMalformedException e) {
//			System.out.println(e.getMessage());
//		}
//		return "redirect:/books";
//	}
//
//	@GetMapping("edit/{id}")
//    public String showUpdateForm(@PathVariable int id, Model model) throws ResourceNotfoundException {
//        Books b = service.getBookById(id);
//        model.addAttribute("book", b);
//        return "update-book";
//    }
//	
//   @PostMapping("update/{id}")
//    public String updatePrice(@PathVariable int id, @Valid Books book, BindingResult result,
//        Model model) throws ObjectMalformedException {
//        if (result.hasErrors()) {
//            book.setBookId(id);
//            return "update-book";
//        }
//
//        service.updateBookPrice(id, book.getPrice());
//        model.addAttribute("books", service.listAllBooks());
//        return "index";
//    }
//	
//   @GetMapping("delete/{id}")
//   public String deleteBook(@PathVariable int id, Model model) {
//       try {
//			Books b = service.getBookById(id);
//			service.deleteBook(id);
//			 model.addAttribute("books", service.listAllBooks());
//		} catch (ResourceNotfoundException e) {
//			System.out.println(e.getMessage());
//		}
//       return "redirect:/books";
//   }
   
   /*
    * Rest API
    */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Books>> listAllBooks() {
		List<Books> books = service.listAllBooks();
		
		if(books.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(books);
	}
	
	@Operation(
		      summary = "Retrieve a Book by Id",
		      description = "Get a Book object by specifying its id. The response is Book object with id, title, author, release year and price.",
		      tags = { "Get Book By Id" })
	@ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Books.class), mediaType = "application/json")}),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	
	@GetMapping("/{id}")
	public Books retrieveBook(@PathVariable int id) throws ResourceNotfoundException {
		return service.getBookById(id);
	}
	
	@GetMapping("/author/{author}")
	public List<Books> listAllBooksByAuthor(@PathVariable String author) {
		return service.listAllByAuthor(author);
	}
	
	@GetMapping("/price/{start}/{end}")
	public List<Books> listAllBooksByPriceBetween(@PathVariable double start, @PathVariable double end) {
		return service.listAllByPriceBetween(start, end);
	}
	
	@PostMapping
	public ResponseEntity<Books> saveBookDetails(@RequestBody Books book) throws ObjectMalformedException {
	//	return service.saveBookDetails(book);
		
		Books b = service.saveBookDetails(book);
		
		if(b.getBookId() == 0) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok(b);
	}
	
	@PatchMapping("/update/{id}/{price}")
	public String updatePrice(@PathVariable int id, @PathVariable double price) {
		return service.updateBookPrice(id, price);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		service.deleteBook(id);
		return "Book deleted";
	}
}
