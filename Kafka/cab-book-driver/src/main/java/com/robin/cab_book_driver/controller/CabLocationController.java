package com.robin.cab_book_driver.controller;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robin.cab_book_driver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {
	
	
	@Autowired
	private CabLocationService cabLocationService;
	
	@PutMapping
	public ResponseEntity updateLocation() throws InterruptedException {
		
		int range = 100;
		
		while(range>0) {
			System.out.println(Math.random()+" , "+ Math.random());
			cabLocationService.updateLocation(Math.random()+" , "+ Math.random());
			Thread.sleep(1000);
			range --;
		}
		
		return new ResponseEntity<>(Map.of("message","location Updated"),HttpStatus.OK);
	}
}
