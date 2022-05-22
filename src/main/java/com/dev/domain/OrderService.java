package com.dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.dev.domain.enuns.Priority;
import com.dev.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrderService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime openingDate;
 
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime closingDate;
 
	private Integer priority;
	@NotEmpty(message = "The field observations is required")
	private String observations;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "support_id")
	private Support support; 
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
 
	public OrderService(Integer id, Priority priority,
			String observations, Status status, Support support, Customer customer) {
		this.id = id;
		this.setOpeningDate(LocalDateTime.now());
		this.priority = (priority==null)? 0 : priority.getKey();
		this.observations = observations;
		this.status = (status==null)? 0 : status.getKey();
		this.support = support;
		this.customer = customer;
	}
	
	public OrderService() {
		this.setOpeningDate(LocalDateTime.now());
		this.setPriority(Priority.LOW);
		this.setStatus(Status.OPEN);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDateTime getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getKey();
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getKey();
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
