package com.project.number_increment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.number_increment.services.NumberIncrementServices;

@RestController
public class NumberIncrementController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NumberIncrementServices numberIncrementServices;
	
	@PostMapping("/increment")
	public void incremntNumber()
	{
		numberIncrementServices.increment();
	}

}
