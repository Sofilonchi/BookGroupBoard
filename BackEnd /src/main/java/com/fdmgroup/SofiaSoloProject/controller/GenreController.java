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

import com.fdmgroup.SofiaSoloProject.model.Genre;
import com.fdmgroup.SofiaSoloProject.service.GenreService;

@RestController
public class GenreController {

	private GenreService genreService;

	
	@Autowired
	public GenreController(GenreService genreService) {
		
		super();
		this.genreService = genreService;

	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	@GetMapping("genres")
	public List<Genre> firstEndPoint(){
		
		return genreService.findAll();
	}
	
	@GetMapping("genres/{genreId}")
	public Genre findById(@PathVariable int genreId) {
		
		return genreService.findById(genreId);
		
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	@PostMapping("genres")
	public void createNewGenre(@RequestBody Genre newGenre) {
		
		System.out.println(newGenre);
		genreService.saveGenre(newGenre);
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	@PutMapping("genres/{genreId}")
	public void updateGenre(@RequestBody Genre genre) {
		
		genreService.updateGenre(genre);
		
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	@DeleteMapping("genres/{genreId}")
	public void deleteGenre(@PathVariable int genreId) {
		
		genreService.deleteById(genreId);
		
	}
	
	
}
