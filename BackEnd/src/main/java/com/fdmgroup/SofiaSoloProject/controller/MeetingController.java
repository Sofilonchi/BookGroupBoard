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

import com.fdmgroup.SofiaSoloProject.model.Meeting;
import com.fdmgroup.SofiaSoloProject.service.MeetingService;

@RestController
public class MeetingController {

	private MeetingService meetingService;

	@Autowired
	public MeetingController(MeetingService meetingService) {
		
		super();
		this.meetingService = meetingService;
	
	}
	
	
	@GetMapping("meetings")
	public List<Meeting> firstEndPoint(){
		
		return meetingService.findAll();

	}
	
	@GetMapping("meetings/{meetingId}")
	public Meeting findById(@PathVariable int meetingId) {
		
		return meetingService.findById(meetingId);
		
	}
	
	@GetMapping("meetings/nextbookgroup/{bookgroupId}")
	public Meeting findNext(@PathVariable int bookgroupId) {
		
		return meetingService.findNext(bookgroupId);
		
	}
	
	@GetMapping("meetings/bookgroup/{bookgroupId}")
	public List<Meeting> findByBookGroup(@PathVariable int bookgroupId){
		
		return meetingService.findByBookGroup(bookgroupId);
	}
	
	@PostMapping("meetings")
	public void createNewMeeting(@RequestBody Meeting newMeeting) {
		
		System.out.println(newMeeting);
		meetingService.saveMeeting(newMeeting);
	}
	
	@PutMapping("meetings")
	public void updateMeeting(@RequestBody Meeting meeting) {
		
		meetingService.updateMeeting(meeting);

		
	}
	
	@DeleteMapping("meetings/{meetingId}")
	public void deleteMeeting(@PathVariable int meetingId) {
		
		meetingService.deleteById(meetingId);

	}
	
	
}
