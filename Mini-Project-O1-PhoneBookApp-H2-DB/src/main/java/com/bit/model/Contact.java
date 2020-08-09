package com.bit.model;

import java.util.Date;

import lombok.Data;
@Data
public class Contact{
	Integer contactId;
	public String contactName;
	String contactEmail;
	Long contactNumber;
	Date createdDate;
	Date updatedDate;

}
