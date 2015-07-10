package com.patternbox.promotion.hexagonal.domain;

public interface MailService {

	void sendMessage(String recipient, String subject, String body);
}
