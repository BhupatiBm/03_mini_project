package com.bit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.entity.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity,Serializable> {
	@Query(value = "select stateName from StateMasterEntity")
	public List<String> getAllStates();

}
