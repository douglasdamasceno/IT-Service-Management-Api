package com.dev.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.domain.Customer;
import com.dev.services.CustomerService;

@Controller()
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id){
		Customer customer = customerService.findById(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping()
	public ResponseEntity<List<Customer>> findAll(){
		return ResponseEntity.ok(customerService.findAll());
	}
	
	@PostMapping(consumes="application/json")
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customerPostRequestBody) {
        return new ResponseEntity<>(customerService.save(customerPostRequestBody), HttpStatus.CREATED);
    }

}
