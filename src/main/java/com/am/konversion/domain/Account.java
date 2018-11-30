package com.am.konversion.domain;

import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
@Entity("account")
public abstract class Account {
    
    @Id protected String id;
    protected String name;
    protected Country country;
    protected Currency currency;
    
    protected Set<Campaign> compaigns;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Set<Campaign> getCompaigns() {
		return compaigns;
	}

	public void setCompaigns(Set<Campaign> compaigns) {
		this.compaigns = compaigns;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", country=" + country + ", currency=" + currency
				+ ", compaigns=" + compaigns + "]";
	}
    
    

}
