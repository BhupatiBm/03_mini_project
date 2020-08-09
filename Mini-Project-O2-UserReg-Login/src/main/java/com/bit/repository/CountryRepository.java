package com.bit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.CountryEntity;
import com.bit.entity.UserEntity;

public interface CountryRepository extends JpaRepository<CountryEntity,Serializable> {
}
