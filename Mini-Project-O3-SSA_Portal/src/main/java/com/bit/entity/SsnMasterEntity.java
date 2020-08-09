package com.bit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_MASTER")
public class SsnMasterEntity {
	@Id
	@Column(name = "SSN")
	@GenericGenerator(name = "ssn_seq_gen", strategy = "com.bit.generator.SSNCustomGenerator")
	@GeneratedValue(generator = "ssn_seq_gen")
	private Long ssn;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DATE_OF_BBIRTH")
	private Date dob;
	@Column(name = "STATE")
	private String state;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE",insertable = false)
	private Date updatedDate;

}
