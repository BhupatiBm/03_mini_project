package com.bit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "country_master")
public class Conntry {
	@Id
	private int id;
	private String country;

}
