package com.robin.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.robin.springmvcboot.model.Alien;

@Controller
public class SpringRestController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="aliens",produces= {"application/xml"})
	@ResponseBody
	public List<Alien> getAliens() {
		
		//int i=9/0;
		
		System.out.println("Fetching aliens");
		
		return repo.findAll();
	}
	
	@GetMapping("alien/{aid}")
	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid).orElse(new Alien(0,""));
	}
	
	@PostMapping(path="alien_update",consumes ={"application/json"})
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien) {
		System.out.println("Getting Called");
		repo.save(alien);
		
		return alien;
	}

}
