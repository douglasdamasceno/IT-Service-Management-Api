package com.dev.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String title;
	protected int status;
	protected String details;
	protected String developerMessage;
	protected LocalDateTime timestamp;
}