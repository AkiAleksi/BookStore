package com.example.bookstore.model;

public class Book {

	private String title;
	private String author;
	private int year;
	private int isbn;

	public Book(String title, String author, int year, int isbn) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;

	}

	public String getTitle() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String author() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int year() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int isbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

}
