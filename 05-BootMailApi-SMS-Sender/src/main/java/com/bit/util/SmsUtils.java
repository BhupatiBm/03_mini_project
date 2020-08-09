package com.bit.util;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsUtils{
	   // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACda0139a994d8bd244be4ec68ffb8832c";
    public static final String AUTH_TOKEN = "8bdd6cbbaa0da6c0ac57523c8917fbd8";

    public boolean sendSms(){
    	 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

         Message message = Message
                 .creator(new PhoneNumber("+918599883836"), // to
                         new PhoneNumber("+12515510612"), // from
                         "Where's Wallace?")
                 .create();

         System.out.println(message.getSid());
		return message!=null;
    }
}