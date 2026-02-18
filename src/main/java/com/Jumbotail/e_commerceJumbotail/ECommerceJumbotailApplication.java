package com.Jumbotail.e_commerceJumbotail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ECommerceJumbotailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceJumbotailApplication.class, args);
	}

}
