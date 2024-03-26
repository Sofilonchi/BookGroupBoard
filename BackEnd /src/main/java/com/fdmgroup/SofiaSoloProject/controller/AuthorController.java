package com.fdmgroup.SofiaSoloProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.SofiaSoloProject.model.Author;
import com.fdmgroup.SofiaSoloProject.service.AuthorService;

@RestController
public class AuthorController {

	
	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		
		super();
		this.authorService = authorService;
	
	}
	
	@GetMapping("authors")
	public List<Author> firstEndPoint(){
		
		return authorService.findAll();
		
	}
	
	@GetMapping("authors/{authorId}")
	public Author findById(@PathVariable int authorId) {
		
		return authorService.findById(authorId);
		
	}
	
	@PostMapping("authors")
	public void createNewAuthor(@RequestBody Author newAuthor) {
		
		authorService.saveAuthor(newAuthor);
		
	}
	
	
	@PutMapping("authors/{authorId}")
	public void updateAuthor(@RequestBody Author author) {
		
		authorService.updateAuthor(author);
		
	}
	
	@DeleteMapping("authors/{authorId}")
	public void deleteById(@PathVariable int authorId) {
		
		authorService.deleteById(authorId);
		
	}
}
