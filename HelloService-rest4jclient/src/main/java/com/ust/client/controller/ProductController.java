package com.ust.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.client.model.Product;

@RestController
@RequestMapping("/client/api")
public class ProductController {
	
	@Autowired
	RestTemplate template;
	
	
	@GetMapping("/greet")
	public String fetchGreet()
	{
		String urlgreet = "http://localhost:8072/rest/service/test";
		String greeting = template.getForObject(urlgreet, String.class);
		return greeting;
	}
	@GetMapping("/factorial/{num}")
	public int fetchFactorial(@PathVariable("num") int num)
	{
		String url = "http://localhost:8072/service/factorial/out/"+num;
		int fact = template.getForObject(url, Integer.class);
		return fact;
	}
	@GetMapping("/time")
	public String fetchtime()
	{
		String url ="http://localhost:8072/rest/service/date";
		return template.getForObject(url, String.class);
	}
}
