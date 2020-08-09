package com.bit.controller;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.constants.ApplicationConstant;
import com.bit.model.UserModel;
import com.bit.service.UserService;
@Controller
public class UserAccountController {
	private static final Logger logger=LoggerFactory.getLogger(UserAccountController.class);
	@Autowired
	private UserService userService;

	private int saved=0;

	@GetMapping(value = {"/userReg"})
	public String loadRegForm(Model model) {
		UserModel User=new UserModel();
		model.addAttribute("UserAcc",User);
		logger.debug(ApplicationConstant.LOGGER_loadRegForm_EXECUTION_STARTED);
		try {
			Map<Integer,String> map=userService.getAllCountries();
			model.addAttribute("AllCountry",map);
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}
		if(saved==1)
			model.addAttribute("sucmsg",ApplicationConstant.MESSAGE_REGISTRATION_DONE);
		else if(saved==2)
			model.addAttribute("errmsg",ApplicationConstant.MESSAGE_REGISTRATION_FAILED);
		saved=0;
		logger.info(ApplicationConstant.LOGGER_REGISTRATION_FORM_LOADED);
		logger.debug(ApplicationConstant.LOGGER_loadRegForm_EXECUTION_ENDED);
		return ApplicationConstant.USER_REGISTRATION_VIEW;
	}

	@PostMapping(value = {"/saveUSerDtls"})
	public String handleSubmitBtn(@ModelAttribute("UserAcc")UserModel User, Model model) {
		logger.debug(ApplicationConstant.LOGGER_handleSubmitBtn_EXECUTION_STARTED);
		try {

			boolean isSaved= userService.saveContact(User);
			if(isSaved)
				saved=1;
			else
				saved=2;
			
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}
		logger.info(ApplicationConstant.LOGGER_USER_DATA_SAVED);
		logger.debug(ApplicationConstant.LOGGER_handleSubmitBtn_EXECUTION_ENDED);
		
		return ApplicationConstant.USER_SUBMIT_SUCESS_VIEW;
	}

	@GetMapping(value = {"/verifyEmail"})
	@ResponseBody
	public String verifyEmail(@RequestParam("email")String email) {
		logger.debug(ApplicationConstant.LOGGER_verifyEmail_EXECUTION_STARTED);
		UserModel user =null;
		try {
			user = userService.findEmail(email);	
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}
		logger.info(ApplicationConstant.EMAIL_VERIFICATION);
		logger.debug(ApplicationConstant.LOGGER_verifyEmail_EXECUTION_ENDED);
		
		if(user==null)
			return ApplicationConstant.EMAIL_NOT_FOUND;
		else
			return ApplicationConstant.EMAIL_FOUND;
		
	}

	@RequestMapping("/getAllStates")
	@ResponseBody
	public Map<Integer, String> getAllStates(@RequestParam("cid")Integer countryId){
		logger.debug(ApplicationConstant.LOGGER_getAllStates_EXECUTION_STARTED);
		Map<Integer, String> allStates = null;
		try {
			allStates = userService.getAllStates(countryId);
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR);
		}
		logger.info(ApplicationConstant.ALL_STATES_RETRIVED);
		logger.debug(ApplicationConstant.LOGGER_getAllStates_EXECUTION_ENDED);
		return allStates;
	}

	@RequestMapping("/getAllCitys")
	@ResponseBody
	public Map<Integer,String> getAllCitys(@RequestParam("sid")Integer stateId){
		logger.debug(ApplicationConstant.LOGGER_getAllCitys_EXECUTION_STARTED);
		Map<Integer, String> allCitys = null;
		try {
			allCitys =userService.getAllCity(stateId);
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR);
		}
		logger.info(ApplicationConstant.ALL_CITYS_RETRIVED);
		logger.debug(ApplicationConstant.LOGGER_getAllCitys_EXECUTION_ENDED);
		return allCitys; 
	}


}
