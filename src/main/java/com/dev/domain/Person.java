package com.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Person {
	private Integer id;
	private String name;
	private String cpf;
	private String telefone;

}
