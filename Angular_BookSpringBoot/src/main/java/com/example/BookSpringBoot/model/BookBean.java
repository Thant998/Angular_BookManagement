package com.example.BookSpringBoot.model;

import javax.validation.constraints.NotEmpty;

public class BookBean {
	
	@NotEmpty
	private String BookCode;
	@NotEmpty
	private String BookTitle;
	@NotEmpty
	private String BookAuthor;
	@NotEmpty
	private String BookPrice;
	public String getBookCode() {
		return BookCode;
	}
	public void setBookCode(String bookCode) {
		BookCode = bookCode;
	}
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public String getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(String bookPrice) {
		BookPrice = bookPrice;
	}
}
