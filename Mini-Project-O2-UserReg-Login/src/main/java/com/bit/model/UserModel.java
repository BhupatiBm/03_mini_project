package com.bit.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class UserModel{
	public Integer userId;
	public String firstName;
	public String lastName;
	public String emailId;
	public String accountStatus;
	public Long phoneNumber;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	public Date dob;
	public Character gender;
	public Integer countryId;
	public Integer stateId;
	public Integer cityId;
	public String pasword;
	public Date createdDate;
	public Date updateDate;

}
