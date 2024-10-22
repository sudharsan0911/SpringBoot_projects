package com.ust.security.Oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome to UST Trivandrum";
	}

}
