package com.bit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.bit.util.MailUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Application.class, args);
		MailUtils bean = ctx.getBean(MailUtils.class);
		String[] recpitant=new String[2];
		recpitant[0]="bhupatibmpradhan1@gmail.com";
		recpitant[1]="bbm.pradhan@gmail.com";
		String to="bhupatibmpradhan1@gmail.com";
		String subject="test";
		String body="<b>Bulke mail</b>"; 
		//boolean res = bean.sendMail(to, subject, body);
		boolean res = bean.sendEmailNew(to, subject, body);
		System.out.println("email send or not? :"+res);
		
	}

}
