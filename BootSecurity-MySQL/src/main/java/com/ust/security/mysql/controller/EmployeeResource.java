package com.ust.security.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



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
