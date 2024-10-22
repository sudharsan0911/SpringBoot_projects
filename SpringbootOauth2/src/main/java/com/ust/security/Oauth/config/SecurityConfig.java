package com.ust.security.Oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception
	{
		return http
				.authorizeHttpRequests(registry ->
				{
					registry.anyRequest().authenticated();
				}).oauth2Login(Customizer.withDefaults())
				.build();
	}

}
