package com.dev.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	OPEN(0,"ABERTO"),
	PROGRESS(1,"ANDAMENTO"),
	CLOSE(2,"ENCERRADO");
	
	private Integer key;
	private String 	description;
	
	public static Status toEnum(Integer key) {
		if(key==null) {
			return null;
		}
		for(Status value: Status.values()) {
			return value;
		}
		throw new IllegalArgumentException("Prioridade não encontrada");
	}
}
