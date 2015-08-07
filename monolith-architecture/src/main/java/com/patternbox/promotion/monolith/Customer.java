package com.patternbox.promotion.monolith;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name = "findByInterest", query = "SELECT c FROM Customer c WHERE c.interest = :interest")
})
public class Customer {

	@Id
	private Long id;
	
	@NotNull
	private String email;
	
	private String surname;
	
	private String firstName;
	
    @Enumerated(EnumType.STRING)
    private GameCategory interest;

	public String getEmail() {
		return email;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public GameCategory getInterest() {
		return interest;
	}
}
