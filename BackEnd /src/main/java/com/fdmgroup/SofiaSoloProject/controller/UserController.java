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
import com.fdmgroup.SofiaSoloProject.model.User;
import com.fdmgroup.SofiaSoloProject.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		
		super();
		this.userService = userService;
		
	}
	
	
	@GetMapping("users")
	public List<User> firstEndPoint(){
		
		return userService.findAll();
	}
	
	@GetMapping("users/bookgroup{bookgroupId}")
	public List<String> findByBookGroup(@PathVariable int bookgroupId){
		
		return userService.findByBookGroup(bookgroupId);
		
	}
	
	@GetMapping("users/{username}")
	public User findByUsername(@PathVariable String username) {
		
		return userService.findByUsername(username);
		
	}
	
	@GetMapping("users/user{userId}")
	public User findById(@PathVariable int userId) {
		
		return userService.findById(userId);
	}
	
	@GetMapping("users/findbookgroup/{userId}")
	public BookGroup findUserBookGroup(@PathVariable int userId) {
		
		return userService.findUserBookGroup(userId);
		
	}
	
	@GetMapping("users/checkusername/{username}")
	public void checkUniqueUsername(@PathVariable String username) {
		
		userService.checkUnique(username);
	}
	
	@PostMapping("users")
	public void createNewUser(@RequestBody User newUser) {
	
		System.out.println(newUser);
		userService.register(newUser);
		
	}
	
	@PutMapping("users")
	public void updateUser(@RequestBody User user) {
		
		userService.updateUser(user);
	}
	
	@DeleteMapping("users/delete/{userId}")
	public void deleteUser(@PathVariable int userId) {
		
		userService.deleteById(userId);
		
	}

	
	
}
