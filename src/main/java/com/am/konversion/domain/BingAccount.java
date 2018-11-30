package com.am.konversion.domain;

import java.util.Set;

public class BingAccount extends Account {

    public BingAccount() {
	super();
    }

    public BingAccount(String id, String name, Country country, Currency currency, Set<Campaign> compaigns) {
	super();
	this.id = id;
	this.name = name;
	this.country = country;
	this.currency = currency;
	this.compaigns = compaigns;
    }

}
