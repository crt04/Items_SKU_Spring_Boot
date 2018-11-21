package com.hd.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching


public class ItemsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemsServicesApplication.class, args);
	}

}
