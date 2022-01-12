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

}
