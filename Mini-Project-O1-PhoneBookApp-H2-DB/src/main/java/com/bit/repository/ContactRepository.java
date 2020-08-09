package com.bit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity,Serializable> {

	public ContactEntity findByContactEmail(String contactEmail);
	
}
