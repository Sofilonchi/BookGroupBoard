package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.AssignedBookRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.AssignedBook;

@Service
public class AssignmentService {

	
	private AssignedBookRepository assignmentRepository;

	@Autowired
	public AssignmentService(AssignedBookRepository assignmentRepository) {
		
		super();
		this.assignmentRepository = assignmentRepository;
	
	}
	
	
	public List<AssignedBook> findAll(){
		
		return this.assignmentRepository.findAll();
		
	}
	
	public List<AssignedBook> findBybookGroupId(int bookgroupId){
		
		return this.assignmentRepository.findBybookGroupId(bookgroupId);
		
	}
	
	public AssignedBook findCurrent(int bookgroupId) {
		
		List<AssignedBook> assignment;
		assignment = this.assignmentRepository.findCurrent(bookgroupId);
		
		return assignment.get(0);
		
	}
	
	public Optional<AssignedBook> findById(int assignmentId) {
		
		return Optional.of(this.assignmentRepository.findById(assignmentId)
				.orElseThrow(()->new NotFoundException("Assignment with ID: " + assignmentId + " cannot be found")));
		
	}
	
	public void saveAssignment(AssignedBook newAssignment) {
		
		this.assignmentRepository.save(newAssignment);
		
	}
	
	public void updateAssignment(AssignedBook assignment) {
		
		throw new NotAllowedException("Assigned book cannot be updated");
		
	}
	
	public void deleteById(int assignmentId) {
		
		throw new NotAllowedException("Assigned book cannot be deleted");
		
	}
	
}
