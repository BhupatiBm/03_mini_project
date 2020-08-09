package com.bit.exception;

import java.util.Date;

import org.hibernate.annotations.Loader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SsnException {
	private Integer  errCode;
	private String   errDesc;
	private Date    date;
	
	
}
