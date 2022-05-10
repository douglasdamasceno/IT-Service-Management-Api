package com.dev.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Support extends Person{
	private List<OrderService> listOrderServices = new ArrayList<>();

	public Support() {
		super();
	}

	public Support(Integer id, String name, String cpf, String telefone) {
		super(id, name, cpf, telefone);
	}
	
	
}
