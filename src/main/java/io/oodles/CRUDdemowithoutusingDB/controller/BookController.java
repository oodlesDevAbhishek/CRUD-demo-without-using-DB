package io.oodles.CRUDdemowithoutusingDB.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.oodles.CRUDdemowithoutusingDB.models.Book;
import io.oodles.CRUDdemowithoutusingDB.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	//get all book handler  
	@GetMapping("/books")
	public ResponseEntity<?>getBooks(){
		
		List<Book> ls= bookService.getAllBooks();
		if(ls.size() > 0) {
			return new ResponseEntity<List<Book>>(ls ,HttpStatus.OK );
			
		}
		else
			return new ResponseEntity<>("Record not Found In dataBase" , HttpStatus.NOT_FOUND);
	}
	
	
	//get single book handler
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findByName(@PathVariable("id") int id) {
		Book book=null;
		try{
			book= bookService.getBookById(id);
			return new ResponseEntity<Book>(book , HttpStatus.OK);
			
		}
		catch(NoSuchElementException ex) {
			return new ResponseEntity<>("sorry record not find  by id . pls try Again later ..!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	//insert new book handler
	@PostMapping("/book/add")
	public ResponseEntity<?> addBook(@RequestBody Book book){
		try {
		return new ResponseEntity<>("Record added into the Database",HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Record Not inserted ! pls try agian later...",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Update book handler
		@PutMapping("/book/{bookId}")
		public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("bookId")int id ) {
			Book b;
			try {
			     b = bookService.updateBook(book, id);
			     return  new ResponseEntity<Book>(b,HttpStatus.OK);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
	}	
		
		
	//delete book handler
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Boolean>(false ,HttpStatus.NOT_FOUND);
		}
	}		
	
	
}
