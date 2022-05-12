package com.dev.domain.dtos;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class SupportDTO {

	@NotBlank
	private String name;
	@CPF
	private String cpf;
	@NotBlank
	private String telefone;
}
