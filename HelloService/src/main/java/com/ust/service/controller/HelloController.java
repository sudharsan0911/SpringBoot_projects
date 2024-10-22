package com.ust.service.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")
public class HelloController {
	@Autowired
	Environment environment;
	@GetMapping("/test")
	public String sayhello()
	{
		return "Hi there....!";
	}
	@GetMapping("/date")
	public String getDate()
	{
		return " "+LocalDate.now();
	}
	@GetMapping("/addwithtwo/{num}")
	public String add(@PathVariable("num") int num)
	{
		int a = num + 2;
		return a+"";
	}
	@GetMapping("/port")
	public String mesage()
	{
		return "from port : "+environment.getProperty("local.server.port");
	}
	
}
