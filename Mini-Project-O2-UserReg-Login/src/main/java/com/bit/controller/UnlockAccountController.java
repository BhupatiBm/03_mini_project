package com.bit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.constants.ApplicationConstant;
import com.bit.model.UnlockUserAccountModel;
import com.bit.model.UserModel;
import com.bit.service.UserServiceImpl;

@Controller
public class UnlockAccountController {
	@Autowired
	private UserServiceImpl userService;

	public static final Logger logger=LoggerFactory.getLogger(UnlockAccountController.class);
	@GetMapping(value = "/unlockForm")
	public String unlockUserAccountForm(@RequestParam("email")String email,
			Model model) {
		logger.debug(ApplicationConstant.LOGGER_unlockUserAccountForm_EXECUTION_STARTED);
		UnlockUserAccountModel UnlocAcc=new UnlockUserAccountModel();
		UnlocAcc.setEmail(email);
		model.addAttribute("UnlockAcc", UnlocAcc);
		logger.info(ApplicationConstant.LOGGER_UNLOCK_USER_FORM_LOADED);
		logger.debug(ApplicationConstant.LOGGER_unlockUserAccountForm_EXECUTION_ENDED);
		return ApplicationConstant.USER_UNLOCK_VIEW;
	}

	@PostMapping(value = {"/unlockUserAccount"})
	public String unlockAndSaveUserAccount(@ModelAttribute("UnlockAcc")UnlockUserAccountModel UnlockAcc,
			Model model) {
		logger.debug(ApplicationConstant.LOGGER_unlockAndSaveUserAccount_EXECUTION_STARTED);
		try {
			UserModel userModel= userService.getUserByEmailAndPassword(UnlockAcc.getEmail(),UnlockAcc.getTemporaryPassword());
			if(userModel!=null) {
					userModel.setAccountStatus(ApplicationConstant.UNLOCK_ACCOUNT_STATUS);
					userModel.setPasword(UnlockAcc.getNewPassword());
					boolean updateUserAccount = userService.updateUserAccount(userModel);
					if(updateUserAccount) {
						logger.info(ApplicationConstant.LOGGER_ACCOUNT_UNLOCKED);
						logger.debug(ApplicationConstant.LOGGER_unlockAndSaveUserAccount_EXECUTION_ENDED);
						return ApplicationConstant.USER_UNLOCK_SCESS_VIEW;
					}
			}
			model.addAttribute(ApplicationConstant.ERR_KEY, ApplicationConstant.MESSAGE_UNLOCK_FAILED);
		} catch (Exception e) {
			logger.error(ApplicationConstant.LOGGER_EXCEPTION_OCCOUR+e.getMessage());
		}
		logger.info(ApplicationConstant.LOGGER_ACCOUNT_DIDNOT_UNLOCKED);
		logger.debug(ApplicationConstant.LOGGER_unlockAndSaveUserAccount_EXECUTION_ENDED);
		return ApplicationConstant.USER_UNLOCK_VIEW;
	}
}
