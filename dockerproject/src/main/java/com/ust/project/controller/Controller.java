package com.ust.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/greet")
	public String message() {
		return "hi da ";
	}
}
