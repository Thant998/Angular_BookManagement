package com.example.BookSpringBoot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookSpringBoot.dao.BookService;
import com.example.BookSpringBoot.dto.Book;
import com.example.BookSpringBoot.model.BookBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

 @RequestMapping("/api/v1/") 
public class BookController {

	@Autowired
	private BookService bookService;

	@ModelAttribute("bookBean")
	public BookBean getBookBean() {
		return new BookBean();
	}

	@GetMapping(value="/books",produces = "application/json")
	public List<Book> displayBook(ModelMap model) {
		return bookService.getAllBook();

	}

	@PostMapping(value="/books",produces = "application/json")
	public Book addbook(@RequestBody Book book) {

		Book dto = new Book();
		dto.setBookCode(book.getBookCode());
		dto.setBookTitle(book.getBookTitle());
		dto.setBookAuthor(book.getBookAuthor());
		dto.setBookPrice(Double.valueOf(book.getBookPrice()));

		return bookService.saveBook(dto);

	}

	
	@GetMapping("/books/{bookCode}")
	public ResponseEntity<Book> getBookByBookCode(@PathVariable String bookCode) {
		Book book = new Book();
		book = bookService.getBookByBookCode(bookCode);
		return ResponseEntity.ok(book);
	}

	

	@PutMapping(value="/books/{bookCode}",produces = "application/json")
	public ResponseEntity<Book> updateBook(@PathVariable String bookCode, @RequestBody Book bookDetails) {
		Book book = new Book();
		book = bookService.getBookByBookCode(bookCode);
		book.setBookTitle(bookDetails.getBookTitle());
		book.setBookAuthor(bookDetails.getBookAuthor());
		book.setBookPrice(bookDetails.getBookPrice());

		Book updatedBook = bookService.update(book, book.getBookCode());
		return ResponseEntity.ok(updatedBook);
	}

	
	@DeleteMapping("/books/{bookCode}")
	public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable String bookCode) {

		bookService.delete(bookCode);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
