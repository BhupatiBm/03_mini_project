package com.bit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity,Serializable> {
	public List<StateEntity> findByCountryId(Integer countryId);	
}
