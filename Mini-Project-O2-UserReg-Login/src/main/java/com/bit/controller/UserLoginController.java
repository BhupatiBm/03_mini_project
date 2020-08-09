package com.bit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.constants.ApplicationConstant;
import com.bit.model.UserForgotPswdModel;
import com.bit.model.UserLoginModel;
import com.bit.model.UserModel;
import com.bit.service.UserServiceImpl;

@Controller
public class UserLoginController {
	private static Logger logger=LoggerFactory.getLogger(UserLoginController.class);
	@Autowired
	private UserServiceImpl userService;

	@GetMapping(value = {"/","/login"})
	public String showLogInForm(Model model){
		logger.debug(ApplicationConstant.LOGGER_showLogInForm_EXECUTION_STARTED);
		UserLoginModel userLogin=new UserLoginModel();
		model.addAttribute("userLogin", userLogin);
		logger.info(ApplicationConstant.LOGGER_USER_LOGIN_FORM_LOADED);
		logger.debug(ApplicationConstant.LOGGER_showLogInForm_EXECUTION_ENDED);
		return ApplicationConstant.USER_LOGIN_VIEW;
	}

	@PostMapping("/loginUser")
	public String performLogin(@ModelAttribute("userLogin")UserLoginModel userLogin,Model model){
		logger.debug(ApplicationConstant.LOGGER_performLogin_EXECUTION_STARTED);

		try {
			UserModel userDtls = userService.getUserByEmailAndPassword(userLogin.getEmailId(),userLogin.getPasword());
			if(userDtls!=null) {
				if(userDtls.getAccountStatus()!=ApplicationConstant.DEFAULT_ACCOUNT_STATUS) {
					logger.info(ApplicationConstant.LOGGER_USER_LOGEIN_SUCESS);
					logger.debug(ApplicationConstant.LOGGER_performLogin_EXECUTION_ENDED);
					return ApplicationConstant.USER_DASHBOARD_VIEW;
				}
				model.addAttribute(ApplicationConstant.ERR_KEY,ApplicationConstant.MESSAGE_UNLOCK_USER_FIRST);
				logger.warn(ApplicationConstant.LOGGER_USER_LOCKED);
				logger.debug(ApplicationConstant.LOGGER_performLogin_EXECUTION_ENDED);
				return ApplicationConstant.USER_LOGIN_VIEW;
			}
			model.addAttribute(ApplicationConstant.ERR_KEY,ApplicationConstant.MESSAGE_ACCOUNT_NOT_FOUND);
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}

		logger.warn(ApplicationConstant.LOGGER_USER_LOGEIN_FAIL);
		logger.debug(ApplicationConstant.LOGGER_performLogin_EXECUTION_ENDED);
		return ApplicationConstant.USER_LOGIN_VIEW;
	}


	@GetMapping("/forgotPassword")
	public String showForgotPasswordForm(Model model) {
		logger.debug(ApplicationConstant.LOGGER_showForgotPasswordForm_EXECUTION_STARTED);
		UserForgotPswdModel userFrgtPswd=new UserForgotPswdModel();
		model.addAttribute("userForgotPassword", userFrgtPswd);
		logger.info(ApplicationConstant.LOGGER_USER_FORGOT_PASSWORD_FORM_LOADED);
		logger.debug(ApplicationConstant.LOGGER_showForgotPasswordForm_EXECUTION_ENDED);
		return ApplicationConstant.USER_FORGOT_PASSWORD_VIEW;
	}
	@GetMapping("/performForgotPassword")
	public String performForgotPassword(@ModelAttribute("userForgotPassword")UserForgotPswdModel userFrgtPswd,Model model) {
		logger.debug(ApplicationConstant.LOGGER_performForgotPassword_EXECUTION_STARTED);
		try {
			UserModel userDtls = userService.findEmail(userFrgtPswd.getEmailId());
			if(userDtls!=null) {
				if(userDtls.getAccountStatus()==ApplicationConstant.UNLOCK_ACCOUNT_STATUS) {
					boolean send = userService.sendPasswordInSms(userDtls);
					if(send) {
						logger.info(ApplicationConstant.LOGGER_USER_PASSWORD_SENT);
						logger.debug(ApplicationConstant.LOGGER_performForgotPassword_EXECUTION_ENDED);
						model.addAttribute(ApplicationConstant.SUCC_KEY, ApplicationConstant.MESSAGE_PASSWORD_SENT+String.valueOf((userDtls.getPhoneNumber())).substring(9,12));
						return ApplicationConstant.USER_FORGOT_PASSWORD_VIEW;
					}
					model.addAttribute(ApplicationConstant.ERR_KEY,"Phone number "+userDtls.getPhoneNumber()+ "iswrong");
					logger.warn(ApplicationConstant.LOGGER_USER_PASSWORD_NOT_SENT);
					logger.debug(ApplicationConstant.LOGGER_performForgotPassword_EXECUTION_ENDED);
					return ApplicationConstant.USER_FORGOT_PASSWORD_VIEW;
				}
				model.addAttribute(ApplicationConstant.ERR_KEY,ApplicationConstant.MESSAGE_UNLOCK_USER_FIRST);
				logger.warn(ApplicationConstant.LOGGER_USER_PASSWORD_NOT_SENT);
				logger.debug(ApplicationConstant.LOGGER_performForgotPassword_EXECUTION_ENDED);
				return ApplicationConstant.USER_FORGOT_PASSWORD_VIEW;	
			}
			model.addAttribute(ApplicationConstant.ERR_KEY,ApplicationConstant.MESSAGE_ACCOUNT_NOT_FOUND);

		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}
		logger.warn(ApplicationConstant.LOGGER_USER_PASSWORD_NOT_SENT);
		logger.debug(ApplicationConstant.LOGGER_performForgotPassword_EXECUTION_ENDED);
		return ApplicationConstant.USER_FORGOT_PASSWORD_VIEW;	
	}
}
