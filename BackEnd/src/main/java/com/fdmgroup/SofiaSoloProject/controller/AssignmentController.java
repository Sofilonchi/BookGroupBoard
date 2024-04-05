package com.fdmgroup.SofiaSoloProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.SofiaSoloProject.model.AssignedBook;
import com.fdmgroup.SofiaSoloProject.service.AssignmentService;

@RestController
public class AssignmentController {

	private AssignmentService assignmentService;

	@Autowired
	public AssignmentController(AssignmentService assignmentService) {
		
		super();
		this.assignmentService = assignmentService;
	
	}
	
	
	@GetMapping("assignedBooks")
	public List<AssignedBook> firstEndPoint(){
		
		return assignmentService.findAll();
		
	}
	
	@GetMapping("assignedBooks/{assignmentId}")
	public Optional<AssignedBook> findById(@PathVariable int assignmentId) {
		
		return assignmentService.findById(assignmentId);
		
	}
	
	@GetMapping("assignedBooks/all/{bookgroupId}")
	public List<AssignedBook> findByBookGroup(@PathVariable int bookgroupId) {
		
		return assignmentService.findBybookGroupId(bookgroupId);
		
	}
	
	@GetMapping("assignedBooks/current{bookgroupId}")
	public AssignedBook findCurrent(@PathVariable int bookgroupId) {
		
		return assignmentService.findCurrent(bookgroupId);
		
	}
	
	@PostMapping("assignedBooks")
	public void createNewAssignment(@RequestBody AssignedBook newAssignedBook) {
		
		assignmentService.saveAssignment(newAssignedBook);
		
	}
	
	@PutMapping("assignedBooks/{assignmentId}")
	public void updateAssignment(@RequestBody AssignedBook assignedBook) {
		
		assignmentService.updateAssignment(assignedBook);
		
	}
	
	@DeleteMapping("assignedBooks/{assignmentId}")
	public void deleteById(@PathVariable int assignmentId) {
		
		assignmentService.deleteById(assignmentId);
		
	}
	
}
