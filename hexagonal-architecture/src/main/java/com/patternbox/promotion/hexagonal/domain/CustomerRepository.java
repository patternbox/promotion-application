package com.patternbox.promotion.hexagonal.domain;

import java.util.Collection;

public interface CustomerRepository {
	
	Collection<Customer> findCustomersByInterest(GameCategory interest);

}
