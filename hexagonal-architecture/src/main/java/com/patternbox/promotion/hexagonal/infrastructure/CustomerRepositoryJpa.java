package com.patternbox.promotion.hexagonal.infrastructure;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.patternbox.promotion.hexagonal.domain.Customer;
import com.patternbox.promotion.hexagonal.domain.CustomerRepository;
import com.patternbox.promotion.hexagonal.domain.GameCategory;

public class CustomerRepositoryJpa implements CustomerRepository {

    @PersistenceContext
	private EntityManager em;

	public Collection<Customer> findCustomersByInterest(GameCategory interest) {
        return em.createNamedQuery("findByInterest", Customer.class)
        		.setParameter("interest", interest)
        		.getResultList();
	}
}
