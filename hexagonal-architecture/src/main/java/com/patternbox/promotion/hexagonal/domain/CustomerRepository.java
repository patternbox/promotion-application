package com.patternbox.promotion.hexagonal.domain;

import java.util.Collection;

public interface CustomerRepository {
	
	Collection<Customer> findCustomerByInterest(GameCategory category);

}
