package com.ust.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
//@RequestMapping("/security")
public class EmployeeResource {
	
	@GetMapping("/")
	public String greet()
	{
		return "hi there!";
	}
	@GetMapping("/admin")
	public String greetAdmin()
	{
		return "Admin@Work";
	}
	
	@GetMapping("/user")
	public String greetUser() {
		return "User@Work";
	}
	
	
	

}
