package com.patternbox.promotion.layered.domain;

public interface Message {
	
	String recipient();
	
	String subject();
	
	String body();
}
