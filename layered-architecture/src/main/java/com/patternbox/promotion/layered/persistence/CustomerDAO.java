package com.patternbox.promotion.layered.persistence;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDAO {

    @PersistenceContext
	private EntityManager em;

    public Collection<Customer> findCustomers() {
        return em.createNamedQuery("findAll", Customer.class).getResultList();
    }

}
