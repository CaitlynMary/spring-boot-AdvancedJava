package com.example.Customquery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

	
	public GlobalHandler() {
		
	}
	@ExceptionHandler(StudentExceptionHandler.class)
	public ResponseEntity<String> handler(StudentExceptionHandler sh){
		
		return new ResponseEntity(sh.getMessage(),HttpStatus.NOT_FOUND);
	}
}
