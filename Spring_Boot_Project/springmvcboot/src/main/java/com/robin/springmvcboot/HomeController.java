package com.robin.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robin.springmvcboot.model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page request");
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j, ModelMap m) {
		
		int sum = i+j;
		m.addAttribute("sum", sum);
		
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result",repo.findAll());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid,Model m) {
		
		
		m.addAttribute("result",repo.findById(aid));
		return "showAliens";
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname,Model m) {
		
		
//		m.addAttribute("result",repo.findByAnameOrderByAidDesc(aname));
		m.addAttribute("result",repo.find(aname));
		return "showAliens";
	}
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a) {
		repo.save(a);
		return "result";
	}

}
