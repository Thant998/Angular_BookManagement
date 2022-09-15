package com.example.BookSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.BookSpringBoot.dto.Book;

public interface BookRepository extends CrudRepository<Book,String>{ 
	
	
	Book findByBookCode( String code);
}
