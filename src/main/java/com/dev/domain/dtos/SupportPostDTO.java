package com.dev.domain.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.dev.domain.Support;

import lombok.Data;

@Data
public class SupportPostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	@CPF
	private String cpf;
	private String telefone;
	
	public SupportPostDTO(Support support) {
		this.name = support.getName();
		this.cpf = support.getCpf();
		this.telefone = support.getTelefone();
	}
	
	
	
}
