package com.bit.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@XmlRootElement(name = "person")
public class ssnEnrollmentRequest {
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern = "yyy-mm-dd")
	private Date dob;
	private String state;

}
