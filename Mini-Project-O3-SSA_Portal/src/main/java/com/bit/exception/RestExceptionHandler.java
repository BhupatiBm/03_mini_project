package com.bit.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value =noDataFoundException.class)
	public ResponseEntity<SsnException> noDataFoundException(){
		SsnException ex=new SsnException(400,"No data Found",new Date());
		return new ResponseEntity<SsnException>(ex,HttpStatus.BAD_REQUEST);
	}
	
}
