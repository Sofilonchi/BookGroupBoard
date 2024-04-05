package com.fdmgroup.SofiaSoloProject.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.MeetingRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.model.Meeting;

@Service
public class MeetingService {
	
	private MeetingRepository meetingRepository;
	Timestamp curDate = new Timestamp(System.currentTimeMillis());		//current datetime as a timepstamp to compare 

	
	@Autowired
	public MeetingService(MeetingRepository meetingRepository) {
		super();
		this.meetingRepository = meetingRepository;
	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<Meeting> findAll(){
		
		return this.meetingRepository.findAll();
		//ordered by date newest first
	
	}
	
	
	public List<Meeting> findByBookGroup(int groupId){
		
		return this.meetingRepository.findByBookGroupId(groupId);
		
		//this will only be called when the group exists
		//since the bookgroupId will be that of the user
		
	}
	
	
	public Meeting findNext(int groupId) {
		
		return this.meetingRepository.findUpComing(groupId);
		
		//this will only be called when the group exists
		//since the bookgroupId will be that of the user
		
	}
	
	
	public Meeting findById(int meetingId) {
	
		return this.meetingRepository.findById(meetingId)
				.orElseThrow(()->new NotFoundException("Meeting with ID: " + meetingId + " cannot be found"));
	
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveMeeting(Meeting newMeeting) {
		
		this.meetingRepository.save(newMeeting);
		
		
		//add details here to set the book group it corresponds to
		//as the bookgroup that the user who makes it belongs to
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	/**
	 * Method to update meeting
	 * Only upcoming meeting can be changed, otherwise throws error
	 * @param meeting
	 */
	public void updateMeeting(Meeting meeting) {
		
		if (meetingRepository.existsById(meeting.getId())) {
			
			if (meeting.getDate().compareTo(curDate) > 0) {
				
				meetingRepository.save(meeting);
				return;
				
			}
			else {
				
				throw new NotAllowedException("Cannot update past meeting");
			}

		}
		
		throw new NotFoundException("Invalid ID: " + meeting.getId());
		
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	/**
	 * Method to delete a meeting by its ID
	 * Only possible for upcoming meetings
	 * Otherwise throws an exception
	 * @param meetingId
	 */
	public void deleteById(int meetingId) {
		
		Meeting meeting = findById(meetingId);
		
		if (meeting.getDate().compareTo(curDate) > 0) {
			
			meetingRepository.deleteById(meetingId);
			return;
			
		}
		else {
			
			throw new NotAllowedException("Cannot delete past meeting");
		}
	
	}
}
