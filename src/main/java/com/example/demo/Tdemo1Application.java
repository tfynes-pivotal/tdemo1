package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Tdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tdemo1Application.class, args);
	}

	@RequestMapping("/")
	public String index() {
		String message = System.getenv("message");
		if (message == null) {
			message = "";
		}
		String response = message;
		System.out.println(response);
		System.out.println("");
		return response + "\n";
	}
		
}
