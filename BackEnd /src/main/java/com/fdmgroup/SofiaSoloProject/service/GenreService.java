package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.GenreRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.Genre;

@Service
public class GenreService {

	
	private GenreRepository genreRepository;

	@Autowired
	public GenreService(GenreRepository genreRepository) {
		
		super();
		this.genreRepository = genreRepository;
	
	}
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<Genre> findAll(){
		
		return this.genreRepository.findAll();
	
	}
	
	public Genre findById(int genreId) {
		
		if (this.genreRepository.existsById(genreId)) {
			
			return this.genreRepository.findById(genreId);
			
		}
		else {
			
			throw new NotFoundException("Genre with ID: " + genreId + " cannot be found");
			
		}
		
	}
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveGenre(Genre newGenre) {
		
		this.genreRepository.save(newGenre);
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateGenre(Genre genre) {
		
		if (genreRepository.existsById(genre.getId())) {
			
			genreRepository.save(genre);
			
		}
		else {
			
			throw new NotFoundException("Genre with ID: " + genre.getId() + " cannot be found");

		}
		
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int genreId) {
		
		genreRepository.deleteById(genreId);
		
	}
	
	
}
