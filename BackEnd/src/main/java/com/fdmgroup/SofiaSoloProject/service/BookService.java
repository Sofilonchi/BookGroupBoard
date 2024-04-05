package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.BookRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.Author;
import com.fdmgroup.SofiaSoloProject.model.Book;
import com.fdmgroup.SofiaSoloProject.model.Genre;

@Service
public class BookService {

	
	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		
		super();
		this.bookRepository = bookRepository;
	
	}
	
	/**
	 * Method to return all of the books in the database
	 * @return -- list of books
	 */
	public List<Book> findAll(){
		
		return this.bookRepository.findAll();
		
	}
	
	
	/**
	 * Method to return all of the books by a given author
	 * @param name	-- user input of author name
	 * @return		-- list of books
	 */
	public List<Book> findAllAuthor(String name){
		
		if (this.bookRepository.findByauthorName(name).size()==0) {
			
			throw new NotFoundException("Author " + name + " cannot be found");
		
		}
		else {
			
			return this.bookRepository.findByauthorName(name);
		
		}
		
	}
	
	/**
	 * Method to find books from title
	 * @param title
	 * @return
	 */
	public List<Book> findBytitle(String title) {
		
		if (this.bookRepository.findPartialMatch(title).size()== 0) {
			
			throw new NotFoundException("No book with title " + title + " found in database");
		}
		else {
			
			return this.bookRepository.findPartialMatch(title);
			
		}
		
	}
	

	/**
	 * Method to find book by id
	 * @param bookId	-- user input of book id
	 * @return			-- book
	 */
	public Book findById(int bookId) {
		
		return this.bookRepository.findById(bookId)
				.orElseThrow(()->new NotFoundException("Book with ID: " + bookId + " cannot be found"));
		
	}
	
	
	/**
	 * Method to find the full name of the author of a book
	 * @param bookId	-- user input of book id
	 * @return			-- String of author name
	 */
	public String findAuthor(int bookId) {
		
		Author author = this.bookRepository.findAuthor(bookId);
		return author.getFname() + " " + author.getLname();
		
	}
	
	
	/**
	 * Method to save a new book to the database 
	 * @param newBook	-- details of the new book through user input
	 */
	public void saveBook(Book newBook) {
		
		this.bookRepository.save(newBook);
		
	}
	
	
	/**
	 * Method to change the details of an existing book
	 * Throws exception, books will not change once in database
	 * @param book
	 */
	public void updateBook(Book book) {
		
		throw new NotAllowedException("Book cannot be updated");
		
	}
	
	
	/**
	 * Method to delete book from database
	 * @param bookId
	 */
	public void deleteById(int bookId) {
		
		throw new NotAllowedException("Book cannot be deleted");
	
	}
	
}
