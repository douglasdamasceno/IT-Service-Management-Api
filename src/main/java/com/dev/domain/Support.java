package com.dev.domain;


import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Support extends Person implements Serializable{
//	@OneToMany
//	private List<OrderService> listOrderServices = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	public Support() {
		super();
	}

	public Support(Integer id, String name, String cpf, String telefone) {
		super(id, name, cpf, telefone);
	}
	
	
}
