package com.dev.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ValidationExceptionDetails extends ExceptionDetails{
	private static final long serialVersionUID = 1L;
	private String fields;
	private String fieldsMessage;
}
