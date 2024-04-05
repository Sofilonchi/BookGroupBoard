package com.fdmgroup.SofiaSoloProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.SofiaSoloProject.model.Book;
import com.fdmgroup.SofiaSoloProject.model.Genre;
import com.fdmgroup.SofiaSoloProject.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		
		super();
		this.bookService = bookService;
	
	}
	
	@GetMapping("books")
	public List<Book> firstEndPoint(){
		
		return bookService.findAll();
	}
	
	@GetMapping("books/{Id}")
	public Book findById(@PathVariable int Id) {
		
		return bookService.findById(Id);
	}
	
	@GetMapping("books/bookAuthor/{Id}")
	public String findAuthor(@PathVariable int Id) {
		
		return bookService.findAuthor(Id);
	}
	
	@GetMapping("books/author/{author}")
	public List<Book> bookByAuthor(@PathVariable String author){
		
		return bookService.findAllAuthor(author);
	}

	@PostMapping("books")
	public void createNewBook(@RequestBody Book newBook) {
		
		System.out.println(newBook);
		bookService.saveBook(newBook);
	}
	
	@PutMapping("books/{bookId}")
	public void updateBook(@RequestBody Book book) {
		
		bookService.updateBook(book);
	}
	
	@DeleteMapping("books/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		
		bookService.deleteById(bookId);
	}
	
}
