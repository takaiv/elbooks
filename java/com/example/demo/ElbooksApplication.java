package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude = SecurityAutoConfiguration.class) // セキュリティ無効 
public class ElbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElbooksApplication.class, args);
	}

}
