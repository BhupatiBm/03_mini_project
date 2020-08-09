package com.bit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.constants.ApplicationConstant;
import com.bit.entity.CityEntity;
import com.bit.entity.CountryEntity;
import com.bit.entity.StateEntity;
import com.bit.entity.UserEntity;
import com.bit.model.UserModel;
import com.bit.repository.CityRepository;
import com.bit.repository.ContactRepository;
import com.bit.repository.CountryRepository;
import com.bit.repository.StateRepository;
import com.bit.util.EmailUtil;
import com.bit.util.PasswordGeneratorUtil;
import com.bit.util.SmsUtils;
@Service
public class UserServiceImpl implements UserService {  
	@Autowired
	private ContactRepository userRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private EmailUtil emailuUtils;
	@Autowired
	private PasswordGeneratorUtil passwordGen;
	@Autowired
	private SmsUtils smsUtil;
	@Override
	
	public boolean saveContact(UserModel c) {
		c.setAccountStatus(ApplicationConstant.DEFAULT_ACCOUNT_STATUS);
		c.setPasword(passwordGen.generatePassword(ApplicationConstant.TEMP_PASS_LENGTH));
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(c, entity);
		UserEntity saveEntity=userRepo.save(entity);
		if(saveEntity.getUserId()!=null) {
			boolean status = emailuUtils.sendUserUnlockEmail(c);
			System.out.println(c.getEmailId()+" sent or not:"+status);
			//return emailuUtils.sendUserUnlockEmail(c);
			return true;
		}
			
		return false;
	}

	@Override
	public UserModel findEmail(String email) {
		UserEntity userEntity=userRepo.findByEmailId(email);
		UserModel userModel=null;
		if(userEntity!=null) {
			userModel=new UserModel();
		BeanUtils.copyProperties(userEntity, userModel);
		}
		return userModel;
	}

	@Override
	public Map<Integer, String> getAllCountries() {
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		 List<CountryEntity> countryList=countryRepo.findAll();
		 countryList.forEach(countryEntity->{
			 map.put(countryEntity.getCountryId(),countryEntity.getCountryName());
		 });
		return map;
	}

	@Override
	public Map<Integer, String> getAllStates(Integer countryId) {
		Map<Integer, String> map=new LinkedHashMap<Integer,String>();
		List<StateEntity> stateList = stateRepo.findByCountryId(countryId);
		stateList.forEach(StateEntity->{
			map.put(StateEntity.getStateId(),StateEntity.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getAllCity(Integer stateId) {
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		List<CityEntity> cityList = cityRepo.findByStateId(stateId);
		cityList.forEach(CityEntity->{
			map.put(CityEntity.getCityId(),CityEntity.getCityName());
		});
		return map;
	}

	@Override
	public UserModel getUserByEmailAndPassword(String email,String tempPass) {
		UserEntity userDtls = userRepo.findByEmailIdAndPasword(email,tempPass);
		System.out.println(userDtls+"");
		UserModel user=null;
		if(userDtls!=null) {
			user=new UserModel();
			BeanUtils.copyProperties(userDtls, user);
		}
		return user;
	}

	@Override
	public boolean updateUserAccount(UserModel user) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity updateUser = userRepo.save(entity);
		return updateUser!=null;
	}

	@Override
	public boolean sendPasswordInSms(UserModel user) {
		
			String body=ApplicationConstant.SEND_PASSWORD_BY_SMS_NBODY+user.getPasword();
			String to="+"+user.getPhoneNumber();
			System.out.println("to************ "+to);
			boolean sendSms = smsUtil.sendSms(to, ApplicationConstant.TWILLO_TRAIL_PH_NO,body);
		return sendSms;
	}

}
