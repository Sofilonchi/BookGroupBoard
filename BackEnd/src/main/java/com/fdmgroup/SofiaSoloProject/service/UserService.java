package com.fdmgroup.SofiaSoloProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.GenreRepository;
import com.fdmgroup.SofiaSoloProject.dal.UserRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.model.User;

@Service
public class UserService {

	
	private UserRepository userRepository;
	private GenreService genreService;
	private GenreRepository genreRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, GenreRepository genreRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.genreRepository = genreRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	/////////////////////////////////////////////////////
	// DISPLAY
	/////////////////////////////////////////////////////
	
	public List<User> findAll(){
		
		return this.userRepository.findAll();
	
	}
	
	
	/**
	 * Method displays a list of usernames of the users in a particular book group
	 * @param bookGroupId -- the id of the book group in question
	 * @return
	 */
	public List<String> findByBookGroup(int bookGroupId){
		
		return this.userRepository.findBybookGroup(bookGroupId);
		
	}
	
	
	public List<User> findCompatible(int genreId){
		
		if (this.genreRepository.existsById(genreId) == false) {
			
			throw new NotFoundException("Genre with Id " + genreId + " not found");
		
		}
		else {
			
			return this.userRepository.findCompatible(genreId);
			
		}
		
	}
	

	public User findByUsername(String username) {
		
		return this.userRepository.findByUsername(username);
		
	}
	
	
	public User findById(int userId) {
	
		return this.userRepository.findById(userId)
				.orElseThrow(()->new NotFoundException("User with ID: " + userId + " cannot be found"));
	
	}
	
	public BookGroup findUserBookGroup(int userId) {
		
		return this.userRepository.findUserBookGroup(userId);
		//if no book group, will return null and user is not currently in a book group
	}
	
	public void checkUnique(String username) {
		
		List<User> copies = this.userRepository.checkUniqueId(username);
		
		if (copies.size() != 0) {
			
			throw new NotAllowedException("This username is take, please choose another");
			
		}
		
	}
	
	/////////////////////////////////////////////////////
	//CREATE
	/////////////////////////////////////////////////////
	
	public void saveUser(User newUser) {
		
		this.userRepository.save(newUser);
		
	}
	
	public void register(User user) {
		//hash password
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		this.userRepository.save(user);
	}
	
	
	/////////////////////////////////////////////////////
	// UPDATE
	/////////////////////////////////////////////////////
	
	public void updateUser(User user) {
		
		if (this.userRepository.existsById(user.getId())) {
			
			this.userRepository.save(user);
			return;
		}
		
		throw new NotFoundException("Invalid ID: " + user.getId());
	
	}
	
	
	/////////////////////////////////////////////////////
	// DELETE
	/////////////////////////////////////////////////////
	
	public void deleteById(int userId) {
		
		this.userRepository.deleteById(userId);
	
	}
	

}
