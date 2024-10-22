package com.ust.security.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.security.mysql.model.MyUser;
import com.ust.security.mysql.repository.UserRepository;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	UserRepository repository; 
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/add")
	public MyUser newUser(@RequestBody MyUser user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}
}
