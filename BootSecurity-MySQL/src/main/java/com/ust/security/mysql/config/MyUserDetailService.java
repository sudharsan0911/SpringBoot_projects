package com.ust.security.mysql.config;


import java.util.Optional;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.security.mysql.model.MyUser;
import com.ust.security.mysql.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	Logger log = Logger.getLogger("MyUserDetailService.class"); 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> user = repository.findByUsername(username);
		log.info(username);
		return user.map(MyUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("user not found " + username));
	}
	
	
}
