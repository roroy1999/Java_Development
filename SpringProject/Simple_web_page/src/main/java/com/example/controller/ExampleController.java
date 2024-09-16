package com.example.controller;

import com.example.model.ExampleEntity;
import com.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ExampleController {

    @Autowired
    private ExampleRepository exampleRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Hello, this is your Spring MVC webpage!");
        return "index";
    }

    @RequestMapping(value = "/fetchData", method = RequestMethod.GET)
    public String fetchData(Model model) {
        ExampleEntity entity = new ExampleEntity();
        entity.setMessage("Hello from the Database!");
        exampleRepository.save(entity);

        model.addAttribute("message", entity.getMessage());
        return "index";
    }
}