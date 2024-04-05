package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.AuthorRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.Author;

@Service
public class AuthorService {

	
	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		
		super();
		this.authorRepository = authorRepository;
	
	}
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<Author> findAll(){
		
		return this.authorRepository.findAll();
		
	}
	
	
	public Author findById(int authorId) {
		
		return this.authorRepository.findById(authorId)
				.orElseThrow(()-> new NotFoundException("Author with ID: " + authorId + " cannot be found"));
		
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveAuthor(Author newAuthor) {
		
		this.authorRepository.save(newAuthor);
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateAuthor(Author author) {
		
		throw new NotAllowedException("Author details cannot be updated");
		
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int authorId) {
		
		this.authorRepository.deleteById(authorId);
		
	}
	
}
