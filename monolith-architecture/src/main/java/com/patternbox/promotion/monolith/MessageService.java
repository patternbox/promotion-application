package com.patternbox.promotion.monolith;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageService {

    @Resource(name = "mail/mailSession")
    private Session mailSession;
    
	public void sendMessage(Message message) {

		javax.mail.Message email = new MimeMessage(mailSession);

		try {
			email.setRecipients(RecipientType.TO, InternetAddress.parse(message.recipient(), false));
			email.setSubject(message.subject());
			email.setText(message.body());
			email.setHeader("X-Mailer", "My Mailer");
			email.setSentDate(new Date());
			
			Transport.send(email);
			
		} catch (MessagingException e) {
			throw new IllegalStateException(e);
		}
	}
}
