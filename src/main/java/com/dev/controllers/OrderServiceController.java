package com.dev.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.domain.OrderService;
import com.dev.domain.dtos.OrderServiceDTO;
import com.dev.services.OrderServiceService;

@RestController
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
	@Cacheable("orderservice")
	@ResponseStatus(HttpStatus.OK)
	public Page<OrderServiceDTO> findAll(@PageableDefault(sort="id",direction=Direction.ASC,page=0,size=10) Pageable pageable) throws InterruptedException{
		Thread.sleep(6000);
		Page<OrderServiceDTO> listOrderServicesDTO = orderServiceService.findAll(pageable)
				.map(OrderServiceDTO::new);
		return listOrderServicesDTO;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderServiceDTO>> findAllNoPageble(){
		List<OrderServiceDTO> listOrderServicesDTO = orderServiceService.findAllNonPageble()
				.stream().map(orderService -> new OrderServiceDTO(orderService)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listOrderServicesDTO);
	}
	
	@CacheEvict("orderservice")
	@PostMapping(consumes="application/json")
    public ResponseEntity<OrderService> save(@RequestBody @Valid OrderServiceDTO orderServiceDTO) {
		OrderService orderService =  orderServiceService.create(orderServiceDTO);
        return new ResponseEntity<>(orderService, HttpStatus.CREATED);
    }
	
	@CacheEvict("orderservice")
	@PutMapping(consumes="application/json")
	public ResponseEntity<OrderService> update(@RequestBody @Valid OrderServiceDTO orderServiceDTO) {
		OrderService orderService =  orderServiceService.update(orderServiceDTO);
		return ResponseEntity.ok().body(orderService);
	}
}
