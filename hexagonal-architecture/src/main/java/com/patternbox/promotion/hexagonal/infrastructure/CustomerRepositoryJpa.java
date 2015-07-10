package com.patternbox.promotion.hexagonal.infrastructure;

import java.util.Collection;

import com.patternbox.promotion.hexagonal.domain.Customer;
import com.patternbox.promotion.hexagonal.domain.CustomerRepository;
import com.patternbox.promotion.hexagonal.domain.GameCategory;

public class CustomerRepositoryJpa implements CustomerRepository {

	public Collection<Customer> findCustomerByInterest(GameCategory category) {
		// TODO Auto-generated method stub
		return null;
	}

}
