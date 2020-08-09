package com.bit.service;

import java.util.Map;

import com.bit.entity.UserEntity;
import com.bit.model.UserModel;

public interface UserService {
	public boolean saveContact(UserModel c);
	public UserModel findEmail(String email);
	public Map<Integer, String> getAllCountries();
	public Map<Integer,String> getAllStates(Integer countryId);
	public Map<Integer, String> getAllCity(Integer stateId);
	public UserModel getUserByEmailAndPassword(String email,String tempPass);
	public boolean updateUserAccount(UserModel user);
	public boolean sendPasswordInSms(UserModel user);
	
	
}
