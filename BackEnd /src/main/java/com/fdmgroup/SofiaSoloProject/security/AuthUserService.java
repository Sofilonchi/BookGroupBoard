package com.fdmgroup.SofiaSoloProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.UserRepository;
import com.fdmgroup.SofiaSoloProject.model.User;

@Service
public class AuthUserService implements org.springframework.security.core.userdetails.UserDetailsService{
	
	private UserRepository userRepo;

	@Autowired
	public AuthUserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user;
		
		if (this.userRepo.findByUsername(username)!=null){
			user = this.userRepo.findByUsername(username);
		}
		else {
			throw new RuntimeException("username not found");
		}

		return new AuthUser(user);
	}

}
