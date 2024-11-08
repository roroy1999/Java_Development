package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWoldController {
	
	// need a contoller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to proccess the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	

}
