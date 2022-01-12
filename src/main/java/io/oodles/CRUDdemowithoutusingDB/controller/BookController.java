package io.oodles.CRUDdemowithoutusingDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.oodles.CRUDdemowithoutusingDB.models.Book;
import io.oodles.CRUDdemowithoutusingDB.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	//display all data 
	@GetMapping("/books")
	public List<Book> getBooks(){
		
		return bookService.getAllBooks();
	}
	//get data by id
	@GetMapping("/book/{id}")
	public Book findByName(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	//insert new book
	@PostMapping("/book/add")
	public Book addBook(@RequestBody Book book) {
		Book b=bookService.addBook(book);
		return b;
		
	}
}
