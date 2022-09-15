package com.example.BookSpringBoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BookSpringBoot.dao.BookRepository;
import com.example.BookSpringBoot.dao.BookService;
import com.example.BookSpringBoot.dto.Book;

@SpringBootTest
class BookSpringBootApplicationTests {

	//@Test
	//void contextLoads() {
	//}
	
	@Mock
	BookRepository repo;
	
	@InjectMocks
	BookService bookService;
	
	@Test
	public void getAllBookTest() {
		List<Book> list=new ArrayList<Book>();
		Book b1=new Book();
		b1.setBookCode("101");
		b1.setBookTitle("Java");
		b1.setBookAuthor("James");
		b1.setBookPrice(2000);
		Book b2=new Book();
		b2.setBookCode("102");
		b2.setBookTitle("PHP");
		b2.setBookAuthor("Gosling");
		b2.setBookPrice(1000);
		Book b3=new Book();
		b3.setBookCode("103");
		b3.setBookTitle("ASP");
		b3.setBookAuthor("John");
		b3.setBookPrice(3000);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		when(repo.findAll()).thenReturn(list);
		List<Book> bookList=bookService.getAllBook();
		assertEquals(3,bookList.size());
		verify(repo, times(1)).findAll();
	}
	
	@Test
	public void getByCodeTest() {
		Book setBook=new Book();
		setBook.setBookCode("101");
		setBook.setBookTitle("Java");
		setBook.setBookAuthor("James");
		setBook.setBookPrice(2000);
		when(repo.findByBookCode("101")).thenReturn(setBook);
		Book getBook=bookService.getBookByBookCode("101");
		assertEquals("Java",getBook.getBookTitle());
		assertEquals("James",getBook.getBookAuthor());
		assertEquals(2000,getBook.getBookPrice());
	}
	
	@Test
	public void saveTest() {
		Book setBook=new Book();
		setBook.setBookCode("101");
		setBook.setBookTitle("Java");
		setBook.setBookAuthor("James");
		setBook.setBookPrice(2000);
		bookService.saveBook(setBook);
		verify(repo,times(1)).save(setBook);
	}
	
	@Test
	public void updateTest() {
		Book setBook=new Book();
		setBook.setBookCode("101");
		setBook.setBookTitle("Java");
		setBook.setBookAuthor("James");
		setBook.setBookPrice(2000);
		//bookService.update(setBook);
		verify(repo,times(1)).save(setBook);
	}
	
	@Test
	public void deleteTest() {
		bookService.delete("101");
		verify(repo,times(1)).deleteById("101");
	}
	
	

}
