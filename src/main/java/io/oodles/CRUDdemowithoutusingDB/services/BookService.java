package io.oodles.CRUDdemowithoutusingDB.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.oodles.CRUDdemowithoutusingDB.models.Book;


//dao layer se baat kar rahi ho gi
@Service
public class BookService {
	
	public static List<Book> listBooks = new ArrayList<>();
	
	static {
			listBooks.add(new Book(1,"name01" ,"auth01" ,1120.0));
			listBooks.add(new Book(2 ,"name02" ,"auth02" ,110.0));
			listBooks.add(new Book(3 ,"name03" ,"auth03" ,11230.0));
		
	}
	
	public List<Book> getAllBooks(){
		return listBooks;
	}
	
	public Book getBookById(int id) {
		Book book =null;
		book =listBooks.stream().filter(e->e.getId()== id).findFirst().get();
		return book;
	}
	
	public Book addBook(Book book) {
		listBooks.add(book);
		return book;
	}
	
	
	public Book deleteBook(int bookId) {
		 Book b =null;
		 for(int i=0; i <= listBooks.size(); i++){
		        b = listBooks.get(i);
		        if(b.getId() == bookId) {
		        	listBooks.remove(listBooks.get(i));
		 		   return b;
		        }
		    }
		 return b;
	}
	

	public Book updateBook(Book book, int id) {
		Book b= null;
		for(int i=0;i<=listBooks.size();i++) {
			b=listBooks.get(i);
			if(b.getId()==id) {
				b.setBookName(book.getBookName());
				b.setBookAuther(book.getBookAuther());
				b.setBookPrice(book.getBookPrice());
				return b;
			}
			
		}
		return b;
	}
	
	
	
	

}
