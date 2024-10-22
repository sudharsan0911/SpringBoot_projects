package com.ust.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class controller {
	@GetMapping("/hi")
	public String greet()
	{
		return "hi";
	}

}
