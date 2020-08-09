package com.bit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity,Serializable> {
 public List<CityEntity> findByStateId(Integer stateId);
 
 
}
