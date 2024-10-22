package com.ust.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@RequestMapping("/myfallback")
	public ResponseEntity<String> fallBackmethod()
	{
		return 
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("please try after some time");
	}

}
