package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bit.request.ssnEnrollmentRequest;
import com.bit.service.ssnService;

@RestController
public class ssnEnrollmentRestController {
	@Autowired
	private ssnService personServ;
	@PostMapping(value = {"/savePerson"},
					//produces = {"application/json"},
					consumes = {"application/json"})
	public ResponseEntity<String> handelSubmitteButton(@RequestBody ssnEnrollmentRequest request){
		Long ssn = personServ.ssnEnrolment(request);
		ResponseEntity<String> res=null;
		String body="Enrollment is done. Your SSN: "+ssn;
			System.out.println("Enrollment is done. Your SSN: "+ssn);
			res=new ResponseEntity<>(body,HttpStatus.CREATED);
		return res;
	}

}
