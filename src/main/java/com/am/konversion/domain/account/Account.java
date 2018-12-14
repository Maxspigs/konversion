package com.am.konversion.domain.account;

import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;

@Entity("account")
public abstract class Account {

    @Id
    protected String _id;
    protected String name;
    protected Country country;
    protected Currency currency;
    protected Set<Campaign> campaigns;

//    @Reference(lazy = true)
//    protected Organisation organisation_id;
    
    protected Account() {}
    
    public Account(String id) throws Exception {
	setId(id);
    }

    public Account(String id, String name, Country country, Currency currency) throws Exception {
	setId(id);
	this.name = name;
	this.country = country;
	this.currency = currency;
    }

    public String getId() {
	return _id;
    }

    protected abstract void setId(String id) throws Exception;

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

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    @Override
    public String toString() {
	return "Account [_id=" + _id + ", name=" + name + ", country=" + country + ", currency=" + currency + "]";
    }

}
