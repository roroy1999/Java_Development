package com.robin.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robin.springmvc.dao.AlienDao;
import com.robin.springmvc.model.Alien;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	AlienDao dao;
	
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
		
		m.addAttribute("result",dao.getAliens());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m) {
		
		m.addAttribute("result",dao.getAlien(aid));
		return "showAliens";
	}
	
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute("result") Alien a) {
		
		dao.addAlien(a);
		return "showAliens";
	}

}
