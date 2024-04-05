package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.MessageRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
//import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.model.Message;

@Service
public class MessageService {

	
	private MessageRepository messageRepository;

	@Autowired
	public MessageService(MessageRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<Message> findAll(){
		
		return this.messageRepository.findAll();
	
	}
	
	public List<Message> findByBookGroup(int bookGroupId){
		
		if(this.messageRepository.findBybookGroupId(bookGroupId).size() == 0) {
			
			System.out.println("No messages to display at this time");
		}
		
		return this.messageRepository.findBybookGroupId(bookGroupId);
		
	}
	
	
	public Message findById(int messageId) {
	
		return this.messageRepository.findById(messageId)
				.orElseThrow(()->new NotFoundException("Message with ID: " + messageId + " cannot be found"));
	
	}
	
	
	/////////////////////////////////////////////////////
	// CREATE
	/////////////////////////////////////////////////////
	
	public void saveMessage(Message newMessage) {
		
		this.messageRepository.save(newMessage); 
		
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateMessage(Message message) {
		
		if (messageRepository.existsById(message.getId())) {
			
			throw new NotAllowedException("Message cannot be updated");
		}
		
		throw new NotFoundException("Message with ID " + message.getId() + " does not exist");
	
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int messageId) {
		
		throw new NotAllowedException("Messages cannot be deleted");
	
	}
	
	
}
