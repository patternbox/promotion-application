package com.patternbox.promotion.hexagonal.domain;

public interface Message {
	
	String recipient();
	
	String subject();
	
	String body();
}
