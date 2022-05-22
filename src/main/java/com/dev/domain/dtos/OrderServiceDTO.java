package com.dev.domain.dtos;

import java.io.Serializable;
import com.dev.domain.OrderService;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
 
	private Integer id;
	private Integer priority;
	private String observations;
	private Integer status;
	private Integer support; 
	private Integer customer;
	
	public OrderServiceDTO(OrderService orderService) {
		this.id= orderService.getId();
		this.priority= orderService.getPriority().getKey();
		this.observations= orderService.getObservations();
		this.status= orderService.getStatus().getKey();
		this.support= orderService.getSupport().getId(); 
		this.customer= orderService.getCustomer().getId();
	}
}
