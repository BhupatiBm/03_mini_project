package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bit.exception.RestExceptionHandler;
import com.bit.exception.noDataFoundException;
import com.bit.service.ssnService;
@RestController
public class ssnValidateRestController {
		@Autowired
		private ssnService service;
		
		@GetMapping(value = {"/ssnValidate/{SSN}/{STATE}"})
		public ResponseEntity<String> ssnValidationPortal(@PathVariable("SSN")String ssn,@PathVariable("STATE")String state){
			String check = service.checkEnrollment(Long.parseLong(ssn),state);
			ResponseEntity<String> res=null;
			String body="your enrollment is: "+check;
			if(check=="valid") {
				System.out.println("your enrollment is: "+check);
			res=new ResponseEntity<String>(body, HttpStatus.ACCEPTED);
			return res;
			}
			else {
				throw new  noDataFoundException("NO data Found");
			}
		}
}
