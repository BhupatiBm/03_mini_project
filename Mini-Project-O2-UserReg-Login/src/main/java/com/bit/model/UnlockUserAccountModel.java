package com.bit.model;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class UnlockUserAccountModel { 
	private String email;
	private String temporaryPassword;
	private String newPassword;
	private String confirmPassword;
}
