package com.dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Support extends Person{
//	@OneToMany
//	private List<OrderService> listOrderServices = new ArrayList<>();

	public Support() {
		super();
	}

	public Support(Integer id, String name, String cpf, String telefone) {
		super(id, name, cpf, telefone);
	}
	
	
}
