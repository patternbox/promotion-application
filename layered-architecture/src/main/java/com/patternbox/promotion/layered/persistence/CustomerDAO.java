package com.patternbox.promotion.layered.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDAO {

    @PersistenceContext
	private EntityManager em;

	public Collection<Customer> findCustomersByInterest(GameCategory interest) {
        return em.createNamedQuery("findByInterest", Customer.class)
        		.setParameter("interest", interest)
        		.getResultList();
	}
}
