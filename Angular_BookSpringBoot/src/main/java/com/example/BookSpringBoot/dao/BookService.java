package com.example.BookSpringBoot.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookSpringBoot.dto.Book;


@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	
	public List<Book> getAllBook(){
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}
	
	//getting a specific record by using the method findById() of CrudRepository
	
	public Book getBookByBookCode(String code){
		return bookRepository.findByBookCode(code);
	}
	
	//saving a specific record by using the method save() of CrudRepository
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(String code) {
		 bookRepository.deleteById(code);;
		
	}
	
	// updating a record
	public Book update(Book book,String BookCode) {
		return bookRepository.save(book);
	}
		
}
