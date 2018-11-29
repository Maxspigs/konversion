package com.am.konversion.domain;

import java.util.Set;

import org.mongodb.morphia.annotations.Validation;

public class AdwordsAccount extends Account {
	
	public AdwordsAccount() {
		super();
	}
	
	public AdwordsAccount(String id, String name, Country country, Currency currency, Set<Campaign> compaigns) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.currency = currency;
		this.compaigns = compaigns;
	}
	
	
	
}
