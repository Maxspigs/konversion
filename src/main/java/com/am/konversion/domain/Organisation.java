package com.am.konversion.domain;

import java.util.HashSet;
import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.am.konversion.domain.account.Account;

@Entity("organisation")
public class Organisation {

    @Id
    private String id;
    private String name;
    @Reference(lazy = true)
    Set<Account> accounts = new HashSet<Account>();
    @Embedded
    Set<Order> orders = new HashSet<Order>();

    public Organisation(String id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public Organisation() {
	super();
    }

    public String getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Set<Account> getAccounts() {
	return accounts;
    }

    public Set<Order> getOrders() {
	return orders;
    }

    @Override
    public String toString() {
	return "Organisation [id=" + id + ", name=" + name + ", accounts=" + accounts + ", orders=" + orders + "]";
    }

}
