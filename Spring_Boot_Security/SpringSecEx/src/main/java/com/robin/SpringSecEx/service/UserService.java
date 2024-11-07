package com.robin.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;

import com.robin.SpringSecEx.model.Users;
import com.robin.SpringSecEx.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2A,12);//2a specifies version example 2a here: $2a$10$uWMjQCxkrM1TQrEyB7BzMuIQFKGIWmi8FesQUgcc6zMXi2yceq66i
	
	public Users register(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	/*
	Output generated
	
	{
	    "id": -44,
	    "username": "jaggu",
	    "password": "$2a$12$cgrl.wC1FJFX9Q/rpy2RNOBfQujif99s6M0m9BGOD977DW9DsMkY."
	}
	
	*/

}
