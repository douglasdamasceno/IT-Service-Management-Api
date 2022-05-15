package com.dev.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class SupportPutDTO {
	
	private Integer id;
	@NotNull(message = "The support name cannot be null")
	@NotEmpty(message = "The support name cannot be empty")
	private String name;
	@CPF
	private String cpf;
	@NotBlank(message = "The support telefone cannot be null")
	private String telefone;
}
