package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableCaching
public class ServiceManagementApplication {	
	public static void main(String[] args) {
		SpringApplication.run(ServiceManagementApplication.class, args);
	}

}
