package com.dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Customer;
import com.dev.repositories.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findById(Integer id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Support ID not found"));
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer save(Customer userPostRequestBody) {
		return customerRepository.save(userPostRequestBody);
	}
}
