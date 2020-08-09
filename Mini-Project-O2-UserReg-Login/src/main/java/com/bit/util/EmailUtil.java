package com.bit.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bit.model.UserModel;
@Component
public class EmailUtil {
	@Autowired
	JavaMailSender javaMailSender;

	public boolean sendUserUnlockEmail(UserModel userAcc) {
		boolean isSent=false;
		try {
			
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setTo(userAcc.getEmailId());
			helper.setSubject("Unlock Your BIT Account");
			helper.setText(getUnlockAccountEmailBodyCustomise(userAcc),true);
			javaMailSender.send(message);
			isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
	
	public String getUnlockAccountEmailBodyCustomise(UserModel userAcc) throws IOException {
		StringBuffer sb=new StringBuffer("");
		FileReader fr=new FileReader("USE_UNLOCK_EMAIL_BODY_TEMPLET.txt");
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while (line!=null) {
			sb.append(line);
			line=br.readLine();
		}
		br.close();
		String mailBody=sb.toString();
		mailBody=mailBody.replace("{Fname}",userAcc.getFirstName());
		mailBody=mailBody.replace("{Lname}",userAcc.getLastName());
		mailBody=mailBody.replace("{TempPassword}", userAcc.getPasword());
		mailBody=mailBody.replace("{Email}", userAcc.getEmailId());
		
		return mailBody;
	}

}
