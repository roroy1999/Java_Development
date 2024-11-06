package com.robin.SpringSecEx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/Home")
	public String greet(HttpServletRequest e) {
		return "Welcome to Agro"+e.getSession().getId();
	}
}
