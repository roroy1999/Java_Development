package com.robin.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;

import com.robin.SpringSecEx.model.Users;
import com.robin.SpringSecEx.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JWTService jwtService;
	
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

	public String verify(Users user) {
		// TODO Auto-generated method stub
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		if(authentication.isAuthenticated())
			return jwtService.generateToken();
		return "failure";
	}

}
