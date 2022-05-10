package com.dev.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Person implements Serializable{
	private List<OrderService> listOrderServices = new ArrayList<>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String name, String cpf, String telefone) {
		super(id, name, cpf, telefone);
		// TODO Auto-generated constructor stub
	}
	
	
}
