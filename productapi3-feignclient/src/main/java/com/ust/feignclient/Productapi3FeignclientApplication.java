package com.ust.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Productapi3FeignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Productapi3FeignclientApplication.class, args);
	}

}
