package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.BookGroupRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.BookGroup;

@Service
public class BookGroupService {

	private BookGroupRepository bookGroupRepository;

	
	@Autowired
	public BookGroupService(BookGroupRepository bookGroupRepository) {
		
		super();
		this.bookGroupRepository = bookGroupRepository;
		
	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<BookGroup> findAll(){
		
		return this.bookGroupRepository.findAll();
		
	}
	
	
	public BookGroup findById(int bookGroupId) {
		
		if (this.bookGroupRepository.existsById(bookGroupId)) {
			
			return this.bookGroupRepository.findById(bookGroupId);
			
		}
		else {
			
			throw new NotFoundException("Book group with ID: " + bookGroupId + " cannot be found");
		}
		
	}
	
	
	public List<BookGroup> findGenreAvailable(int genreId){
		
		return this.bookGroupRepository.findGenreAvailable(genreId);
		
	}
	
	
	public List<BookGroup> findSpecificAvailable(int genreId, int locationId){

		return this.bookGroupRepository.findSpecificAvailable(genreId, locationId);
		
	}
	
	/**
	 * Method to display book groups with openings (less than 10 members)
	 * Starting at the most specific with chosen location and genre
	 * the with only matching genre and then with no match
	 * User will then have the choice to select a group or wait for more users to join
	 * @param genreId
	 * @param locationId
	 * @return
	 */
	public List<BookGroup> chooseGroup(int genreId, int locationId){
		
		List<BookGroup> specific = findSpecificAvailable(genreId, locationId);
		List<BookGroup> genre = findGenreAvailable(genreId);
		
		if (specific.size() != 0) {
			
			return specific;
		}
		else if (genre.size() !=0 ) {
			
			return genre;
		}
		else {
			
			List<BookGroup> all = this.bookGroupRepository.findAny();
			
			if (all.size()==0) {
				
				System.out.println("All book groups are full at this time, please check again later");
			}
			
			return all;
		
		}
		
		
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveBookGroup(BookGroup newBookGroup) {
		
		this.bookGroupRepository.save(newBookGroup);
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateBookGroup(BookGroup bookGroup) {
		
		if (bookGroupRepository.existsById(bookGroup.getId())) {
			
			bookGroupRepository.save(bookGroup);
			return;
			
		}
		
		throw new NotFoundException("Invalid Book Group: " + bookGroup);
		 
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int bookGroupId) {
		
		this.bookGroupRepository.deleteById(bookGroupId);
		//check if id exists?
	}
	
	
}
