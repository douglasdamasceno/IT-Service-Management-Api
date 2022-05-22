package com.dev.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Customer;
import com.dev.domain.OrderService;
import com.dev.domain.Support;
import com.dev.domain.dtos.OrderServiceDTO;
import com.dev.domain.enuns.Priority;
import com.dev.domain.enuns.Status;
import com.dev.repositories.OrderServiceRepository;


@Service
public class OrderServiceService {
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private SupportService supportService;
	
	@Autowired
	private CustomerService customerService;
	
	public OrderService findById(Integer id) {
		return orderServiceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("OrderService ID not found"));
	}
	
	public List<OrderService> findAll() {
		return orderServiceRepository.findAll();
	}
	
	public OrderService save(OrderService orderService) {
		return orderServiceRepository.save(orderService);
	}
	
	public void delete(Integer id) {
		orderServiceRepository.deleteById(id);
	}
	
	public OrderService create(@Valid OrderServiceDTO orderServiceDTO) {
		return fromDTO(orderServiceDTO);
	}
	
	private OrderService fromDTO(OrderServiceDTO orderServiceDTO) {
		OrderService orderService = new OrderService();
		orderService.setId(orderServiceDTO.getId());
		orderService.setObservations(orderServiceDTO.getObservations());
		orderService.setPriority(Priority.toEnum(orderServiceDTO.getPriority()));
		orderService.setStatus(Status.toEnum(orderServiceDTO.getStatus()));
		
		Support support = supportService.findById(orderServiceDTO.getSupport());
		Customer customer = customerService.findById(orderServiceDTO.getCustomer());
		
		orderService.setCustomer(customer);
		orderService.setSupport(support);
		
		return orderService;
	}
}
