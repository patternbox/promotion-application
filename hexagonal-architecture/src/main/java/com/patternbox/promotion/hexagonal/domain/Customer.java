package com.patternbox.promotion.hexagonal.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAll", query = "SELECT c FROM Customer c")
})
public class Customer {

	@Id
	private Long id;
	
	private String email;
	
	private String surname;
	
	private String firstName;
	
	private Set<GameCategory> interests;

	public String getEmail() {
		return email;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public Set<GameCategory> getInterests() {
		return interests;
	}
}
