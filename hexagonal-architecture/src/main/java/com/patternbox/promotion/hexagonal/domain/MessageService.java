package com.patternbox.promotion.hexagonal.domain;

public interface MessageService {

	void sendMessage(String recipient, String subject, String body);
}
