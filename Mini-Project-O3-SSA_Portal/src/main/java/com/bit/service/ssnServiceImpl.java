package com.bit.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.entity.SsnMasterEntity;
import com.bit.repository.SsnMAsterRepository;
import com.bit.repository.StateMasterRepository;
import com.bit.request.ssnEnrollmentRequest;
@Service
public class ssnServiceImpl implements ssnService{
	
	@Autowired
	private SsnMAsterRepository ssnMaster;
	@Autowired
	private StateMasterRepository stateRepo;
	
	@Override
	public Long ssnEnrolment(ssnEnrollmentRequest request){
		SsnMasterEntity entity=new SsnMasterEntity();
		BeanUtils.copyProperties(request,entity);
		SsnMasterEntity enroll = ssnMaster.save(entity);
		if(enroll!=null)
			return enroll.getSsn();
		return null;
		
	}

	@Override
	public List<String> getAllStateName() {
	return  stateRepo.getAllStates();
	}

	@Override
	public String checkEnrollment(Long ssn, String state) {
		SsnMasterEntity check = ssnMaster.findBySsnAndState(ssn, state);
		if(check!=null)
			return "valid";
		return "invalid";
	}
}
