package com.am.konversion.domain.account;

import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.am.konversion.domain.Campaign;
import com.am.konversion.domain.Organisation;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
@Entity("account")
public abstract class Account {
    
    @Id protected String _id;
    protected String name;
    protected Country country;
    protected Currency currency;
    
    @Reference(lazy=true)
    protected Organisation organisation_id;
    
    protected Set<Campaign> compaigns;

	public String getId() {
		return _id;
	}

	public abstract void setId(String id) throws Exception;
	
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
		return "Account [id=" + _id + ", name=" + name + ", country=" + country + ", currency=" + currency
				+ ", compaigns=" + compaigns + "]";
	}
    
    

}
