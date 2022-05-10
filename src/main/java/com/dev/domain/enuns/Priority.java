package com.dev.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
	LOW(0,"BAIXA"),
	MEDIUM(1,"MEDIA"),
	HIGH(2,"ALTA"),;
	
	private Integer key;
	private String 	description;
	
	public static Priority toEnum(Integer key) {
		if(key==null) {
			return null;
		}
		for(Priority value: Priority.values()) {
			return value;
		}
		throw new IllegalArgumentException("Prioridade não encontrada");
	}
}
