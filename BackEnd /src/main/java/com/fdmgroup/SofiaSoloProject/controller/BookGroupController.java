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

import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.service.BookGroupService;

@RestController
public class BookGroupController {

	
	private BookGroupService bookGroupService;

	@Autowired
	public BookGroupController(BookGroupService bookGroupService) {
		
		super();
		this.bookGroupService = bookGroupService;
	
	}
	
	@GetMapping("bookgroups")
	public List<BookGroup> firstEndPoint(){
		
		return bookGroupService.findAll();
		
	}
	
	@GetMapping("bookgroups/{bookgroupId}")
	public BookGroup findById(@PathVariable int bookgroupId) {
		
		return bookGroupService.findById(bookgroupId);
		
	}
	
	@GetMapping("bookgroups/{genreId}/{locationId}")
	public List<BookGroup> findGroup(@PathVariable int genreId, @PathVariable int locationId){
		
		return bookGroupService.chooseGroup(genreId, locationId);

		
	}
	
	@PostMapping("bookgroups")
	public void createNewBookGroup(@RequestBody BookGroup newBookGroup) {
		
		System.out.println(newBookGroup);
		bookGroupService.saveBookGroup(newBookGroup);
		
	}
	
	@PutMapping("bookgroups/{bookGroupId}")
	public void updateBookGroup(@RequestBody BookGroup bookGroup) {
		
		bookGroupService.updateBookGroup(bookGroup);
		
	}
	
	@DeleteMapping("bookgroups/{bookGroupId}")
	public void deleteBookGroup(@PathVariable int bookGroupId) {
		
		
		bookGroupService.deleteById(bookGroupId);
	}
	
	
	
}
