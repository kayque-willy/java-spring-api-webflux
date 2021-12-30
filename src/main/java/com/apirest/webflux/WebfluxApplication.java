package com.apirest.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
		System.out.println("Olá mundo, Webflux!");
		System.out.println("API listen on port 8080: http://localhost:8080/api-webflux");
	}

}
