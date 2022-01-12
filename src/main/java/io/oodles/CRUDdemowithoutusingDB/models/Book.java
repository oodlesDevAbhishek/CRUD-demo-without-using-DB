package io.oodles.CRUDdemowithoutusingDB.models;

import lombok.Data;

public @Data class Book {

	public Book(int id , String bookName, String bookAuther, double bookPrice) {
		this.id=id;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.bookPrice = bookPrice;// TODO Auto-generated constructor stub
	}
	private int id;
	private String bookName ;
	private String bookAuther;
	private double bookPrice;
	public int getId() {
		
		return id;
	}
}
