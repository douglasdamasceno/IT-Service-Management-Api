package com.dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.domain.Customer;
import com.dev.domain.OrderService;
import com.dev.domain.Support;
import com.dev.domain.enuns.Priority;
import com.dev.domain.enuns.Status;
import com.dev.repositories.CustomerRepository;
import com.dev.repositories.OrderServiceRepository;
import com.dev.repositories.SupportRepository;

@SpringBootApplication
public class ServiceManagementApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SupportRepository supportRepository;
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer(null,"Douglas", "669.832.880-41", "(88) 99999-9999");
		Customer customer2 = new Customer(null,"Douglas", "755.705.180-70", "(88) 99999-9999");
		Customer customer3 = new Customer(null,"Douglas", "040.995.140-48", "(88) 99999-9999");
		
		Support support = new Support(null,"Maira", "099.516.560-21", "(88) 99999-9999");
		Support support2 = new Support(null,"Maira", "497.791.080-09", "(88) 99999-9999");
		
		OrderService order = new OrderService(null,Priority.HIGH, "PC não liga",Status.OPEN,support,customer);
		OrderService order2 = new OrderService(null,Priority.MEDIUM, "PC esta travando",Status.OPEN,support,customer2);
		OrderService order3 = new OrderService(null,Priority.LOW, "Senha dado erro",Status.OPEN,support2,customer3);
		
//		supportRepository.saveAll(Arrays.asList(support,support2));
//		customerRepository.saveAll(Arrays.asList(customer,customer2,customer3));
//		
//		orderServiceRepository.saveAll(Arrays.asList(order,order2,order3));
		
	}

}
