package com.patternbox.promotion.layered.domain;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.patternbox.promotion.layered.persistence.Customer;
import com.patternbox.promotion.layered.persistence.CustomerDAO;
import com.patternbox.promotion.layered.persistence.GameCategory;

@Stateless
public class PromotionService {

	@Inject
	private CustomerDAO customerDAO;
	
	public void sendPromotions(String template, GameCategory category) {
		for (Customer customer: customerDAO.findCustomers()) {
			// send a message
		}
	}

	public Message createMessage(final Customer customer) {
		return new Message() {

			@Override
			public String recipient() {
				return customer.getEmail();
			}

			@Override
			public String subject() {
				return "New Game ...";
			}

			@Override
			public String body() {
				return String.format("Dear %s %s, ...", customer.getFirstName(), customer.getSurname());
			}};
	}
}
