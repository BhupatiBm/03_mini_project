package com.bit.constants;

public class ApplicationConstant {
	public static final String DEFAULT_ACCOUNT_STATUS="Lock";
	public static final String UNLOCK_ACCOUNT_STATUS="UnLocked";
	public static final int TEMP_PASS_LENGTH=6;
	public static final String TWILLO_TRAIL_PH_NO="+12515510612";
	public static final String SEND_PASSWORD_BY_SMS_NBODY="Your password is: ";
	//errMSg and sccMsg key  and value
	public static final String ERR_KEY="errMsg";
	public static final String SUCC_KEY="succMsg";
	
	//view ===============================
	
	public static final String USER_REGISTRATION_VIEW="userRegistration";
	public static final String USER_SUBMIT_SUCESS_VIEW="redirect:/userReg";
	public static final String USER_LOGIN_VIEW="userLoginForm";
	public static final String USER_UNLOCK_VIEW="unlockUserAccountForm";
	public static final String USER_UNLOCK_SCESS_VIEW="unlockAccountSucess";
	public static final String USER_FORGOT_PASSWORD_VIEW="ForgotPasswordForm";
	public static final String USER_DASHBOARD_VIEW="userDashbord";
	
	//user account controller==========================
	public static final String MESSAGE_REGISTRATION_DONE="-----Registration Completed Sucessfully ------";
	public static final String MESSAGE_REGISTRATION_FAILED="Sorry!!!--->> Please Try Again";
	
	public static final String EMAIL_FOUND="invalid";
	public static final String EMAIL_NOT_FOUND="valid";
	public static final String EMAIL_VERIFICATION="Email verification Done";
	
	
	public static final String 	LOGGER_loadRegForm_EXECUTION_STARTED="***loadRegForm() methode execution started ***";
	public static final String 	LOGGER_loadRegForm_EXECUTION_ENDED="*** loadRegForm() methode execution ended ***";
	public static final String 	LOGGER_REGISTRATION_FORM_LOADED="Registration form Loaded sucssfully";
	
	public static final String 	LOGGER_EXCEPTION_OCCOUR="Exception occoured";
	
	public static final String LOGGER_handleSubmitBtn_EXECUTION_STARTED="***handleSubmitBtn() methode execution started ***";
	public static final String LOGGER_handleSubmitBtn_EXECUTION_ENDED="***handleSubmitBtn() methode execution ended ***";
	public static final String LOGGER_USER_DATA_SAVED="User Details Saved in DB table";
	
	public static final String LOGGER_verifyEmail_EXECUTION_STARTED="***verifyEmail() methode execution started ***";
	public static final String LOGGER_verifyEmail_EXECUTION_ENDED="***verifyEmail() methode execution ended ***";
	public static final String LOGGER_USER_EMAIL_VERIFIED="User male is verified,No duplicate mail found";
	
	public static final String LOGGER_getAllStates_EXECUTION_STARTED="***getAllStates() methode execution started ***";
	public static final String LOGGER_getAllStates_EXECUTION_ENDED="***getAllStates() methode execution ended ***";
	public static final String ALL_STATES_RETRIVED="All states data retrived suessfully";
	
	public static final String LOGGER_getAllCitys_EXECUTION_STARTED="***getAllCitys() methode execution started ***";
	public static final String LOGGER_getAllCitys_EXECUTION_ENDED="***getAllCitys() methode execution ended ***";
	public static final String ALL_CITYS_RETRIVED="All cityes data retrived suessfully";
	
	//unlock user account controller==========================
	public static final String LOGGER_unlockUserAccountForm_EXECUTION_STARTED="***unlockUserAccountForm() methode execution started ***";
	public static final String LOGGER_unlockUserAccountForm_EXECUTION_ENDED="***unlockUserAccountForm() methode execution ended ***";
	public static final String LOGGER_UNLOCK_USER_FORM_LOADED="Unlock user form loaded sucessfully";
	
	public static final String LOGGER_unlockAndSaveUserAccount_EXECUTION_STARTED="***unlockAndSaveUserAccount() methode execution started ***";
	public static final String LOGGER_unlockAndSaveUserAccount_EXECUTION_ENDED="***unlockAndSaveUserAccount() methode execution ended ***";
	public static final String LOGGER_ACCOUNT_UNLOCKED="Account is unlocked sucessfully";
	public static final String LOGGER_ACCOUNT_DIDNOT_UNLOCKED="Error occour while unlocking the account";
	public static final String MESSAGE_UNLOCK_FAILED="Unsuccesfull atempt-----Please try again";
	//user login controller
	
	public static final String LOGGER_showLogInForm_EXECUTION_STARTED="***showLogInForm() methode execution started ***";
	public static final String LOGGER_showLogInForm_EXECUTION_ENDED="***showLogInForm() methode execution ended ***";
	public static final String LOGGER_USER_LOGIN_FORM_LOADED="User Login form loaded sucessfully";
	
	public static final String LOGGER_performLogin_EXECUTION_STARTED="***performLogin() methode execution started ***";
	public static final String LOGGER_performLogin_EXECUTION_ENDED="***performLogin() methode execution ended ***";
	public static final String LOGGER_USER_LOGEIN_SUCESS="User Logedin sucessfully";
	public static final String LOGGER_USER_LOGEIN_FAIL="User Logedin Failed";
	public static final String LOGGER_USER_LOCKED="UnLock your account first";
	public static final String MESSAGE_UNLOCK_USER_FIRST="Your Account is Locked Please UnLock";
	public static final String MESSAGE_ACCOUNT_NOT_FOUND="Account not found or Wrong credentials";
	
	
	public static final String LOGGER_showForgotPasswordForm_EXECUTION_STARTED="***showForgotPasswordForm() methode execution started ***";
	public static final String LOGGER_showForgotPasswordForm_EXECUTION_ENDED="***showForgotPasswordForm() methode execution ended ***";
	public static final String LOGGER_USER_FORGOT_PASSWORD_FORM_LOADED="Forgot password form loaded sucessfully";
	
	public static final String LOGGER_performForgotPassword_EXECUTION_STARTED="***performForgotPassword() methode execution started ***";
	public static final String LOGGER_performForgotPassword_EXECUTION_ENDED="***performForgotPassword() methode execution ended ***";
	public static final String LOGGER_USER_PASSWORD_SENT="Password is sent to registered phone number sucessfully";
	public static final String LOGGER_USER_PASSWORD_NOT_SENT="Password Not sent";
	public static final String MESSAGE_PASSWORD_SENT="Password is sent to your registered phone number: *******";
	
	
}
