package io.oodles.CRUDdemowithoutusingDB.models;

import java.util.Objects;

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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookAuther, other.bookAuther) && Objects.equals(bookName, other.bookName)
				&& Double.doubleToLongBits(bookPrice) == Double.doubleToLongBits(other.bookPrice) && id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookAuther, bookName, bookPrice, id);
	}
}
