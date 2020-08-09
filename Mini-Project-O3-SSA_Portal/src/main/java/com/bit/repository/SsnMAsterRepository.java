package com.bit.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.SsnMasterEntity;

public interface SsnMAsterRepository extends JpaRepository<SsnMasterEntity, Serializable> {
	
	public SsnMasterEntity findBySsnAndState(Long ssn,String state);

}
