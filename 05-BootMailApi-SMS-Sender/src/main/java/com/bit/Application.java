package com.bit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bit.util.SmsUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Application.class, args);
		SmsUtils bean = ctx.getBean(SmsUtils.class);
		boolean sendSms = bean.sendSms();
		System.out.println("sms send or not? :"+sendSms);
		
	}

}
