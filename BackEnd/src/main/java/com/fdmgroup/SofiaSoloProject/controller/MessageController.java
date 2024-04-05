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

import com.fdmgroup.SofiaSoloProject.model.Message;
import com.fdmgroup.SofiaSoloProject.service.MessageService;

@RestController
public class MessageController {

	private MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		
		super();
		this.messageService = messageService;
	
	}
	
	
	@GetMapping("messages")
	public List<Message> firstEndPoint(){
		
		return messageService.findAll();

	}
	

	@GetMapping("messages/{messageId}")
	public Message findById(@PathVariable int messageId) {
		
		return messageService.findById(messageId);
		
	}
	
	
	@GetMapping("messages/bookgroup/{bookgroupId}")
	public List<Message> findByBookGroup(@PathVariable int bookgroupId){
		
		return messageService.findByBookGroup(bookgroupId);
		
	}
	
	
	@PostMapping("messages")
	public void createNewMessage(@RequestBody Message newMessage) {
	
		messageService.saveMessage(newMessage);
		
	}
	
	
	@PutMapping("messages")
	public void updateMessage(@RequestBody Message message) {
		
		messageService.updateMessage(message);

	}
	
	
	@DeleteMapping("messages/{messageId}")
	public void deleteMessage(@PathVariable int messageId) {
		
		messageService.deleteById(messageId);

		
	}
	
	
}
