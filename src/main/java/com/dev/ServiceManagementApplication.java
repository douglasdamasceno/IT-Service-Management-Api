package com.dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.domain.Customer;

@SpringBootApplication
public class ServiceManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
