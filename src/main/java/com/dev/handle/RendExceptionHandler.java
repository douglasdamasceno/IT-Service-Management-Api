package com.dev.handle;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dev.exceptions.BadRequestException;
import com.dev.exceptions.BadRequestExceptionDetails;
import com.dev.exceptions.ExceptionDetails;

@ControllerAdvice
public class RendExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleAllException(ExceptionDetails bre){
		return new ResponseEntity<>(
				ExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.title("Bad Request Execption. Check the Documentation")
				.details(bre.getDeveloperMessage())
				.developerMessage(bre.getClass().getName())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre){
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Execption. Check the Documentation")
				.details(bre.getMessage())
				.developerMessage(bre.getClass().getName())
				.build(),HttpStatus.BAD_REQUEST
				);
	}
	
	
}
