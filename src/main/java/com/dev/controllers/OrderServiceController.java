package com.dev.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.dev.domain.OrderService;
import com.dev.domain.dtos.OrderServiceDTO;
import com.dev.services.OrderServiceService;

@Controller()
@RequestMapping("orders")
public class OrderServiceController {
	@Autowired
	private OrderServiceService orderServiceService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderServiceDTO> findById(@PathVariable Integer id){
		OrderServiceDTO orderServiceDTO =  new OrderServiceDTO(orderServiceService.findById(id));
		return ResponseEntity.ok(orderServiceDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderServiceDTO>> findAll(){
		List<OrderServiceDTO> listOrderServicesDTO = orderServiceService.findAll()
				.stream().map(orderService -> new OrderServiceDTO(orderService)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listOrderServicesDTO);
	}
	
	@PostMapping(consumes="application/json")
    public ResponseEntity<OrderService> save(@RequestBody @Valid OrderServiceDTO orderServiceDTO) {
		OrderService orderService =  orderServiceService.create(orderServiceDTO);
        return new ResponseEntity<>(orderService, HttpStatus.CREATED);
    }
}
