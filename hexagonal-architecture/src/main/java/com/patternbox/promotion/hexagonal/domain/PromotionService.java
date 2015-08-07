package com.patternbox.promotion.hexagonal.domain;

import javax.inject.Inject;

public class PromotionService {

	private final MessageService messageService;

	private final CustomerRepository customerRepository;

	@Inject
	public PromotionService(MessageService messageService, CustomerRepository customerRepository) {
		this.messageService = messageService;
		this.customerRepository = customerRepository;
	}
	
	public void sendPromotions(GameCategory interest) {
		for (Customer customer: customerRepository.findCustomersByInterest(interest)) {
			messageService.sendMessage(createMessage(customer));
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
