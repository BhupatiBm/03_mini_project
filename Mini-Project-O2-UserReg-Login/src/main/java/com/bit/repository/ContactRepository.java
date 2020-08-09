package com.bit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.UserEntity;

public interface ContactRepository extends JpaRepository<UserEntity,Serializable> {

	public UserEntity findByEmailId(String  EmailId);
	public UserEntity findByEmailIdAndPasword(String email,String password);
}
