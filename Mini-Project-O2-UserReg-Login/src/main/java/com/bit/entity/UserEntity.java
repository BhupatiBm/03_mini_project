package com.bit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name ="USER_MASTER")
public class UserEntity {
	@Id
	@SequenceGenerator(
			name = "cid_seq_gen",
			sequenceName = "CONTACT_ID_SEQ",
			allocationSize = 1
			)
	@GeneratedValue(generator ="cid_seq_gen",
					strategy = GenerationType.SEQUENCE
					)
	@Column(name ="USER_ID")
	private Integer userId;
	@Column(name ="FIRST_NAME")
	private String firstName;
	@Column(name ="LAST_NAME")
	private String lastName;
	@Column(name ="EMAIL_ID")
	private String emailId;
	@Column(name ="ACC_STATUS")  
	private String accountStatus;
	@Column(name ="HONE_NUMBER")
	private Long phoneNumber;
	@Column(name ="DOB")
	private Date dob;
	@Column(name ="GENDER")
	private Character gender;
	@Column(name ="COUNTRY_ID")
	private Integer countryId;
	@Column(name ="STATE_ID")
	private Integer stateId;
	@Column(name ="CITY_ID")
	private Integer cityId;
	@Column(name ="USER_PWD")
	private String pasword;
	@Column(name ="CREATED_DATE")
	private Date createdDate;
	@Column(name ="UPDATED_DATE")
	private Date updateDate;
	
	
	

}
