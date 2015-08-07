package com.patternbox.promotion.monolith;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PromotionService {

    @PersistenceContext
	private EntityManager em;

	@Inject
	private MessageService messageService;
	
	public void sendPromotions(GameCategory category) {
		for (Customer customer: findCustomersByInterest(category)) {
			messageService.sendMessage(createMessage(customer));
		}
	}

	public Collection<Customer> findCustomersByInterest(GameCategory interest) {
        return em.createNamedQuery("findByInterest", Customer.class)
        		.setParameter("interest", interest)
        		.getResultList();
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
