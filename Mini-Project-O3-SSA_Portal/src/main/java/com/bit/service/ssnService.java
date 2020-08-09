package com.bit.service;

import java.util.List;
import com.bit.request.ssnEnrollmentRequest;

public interface ssnService {
	public List<String> getAllStateName();
	public Long ssnEnrolment(ssnEnrollmentRequest request);
	public String checkEnrollment(Long ssn,String state);
}
