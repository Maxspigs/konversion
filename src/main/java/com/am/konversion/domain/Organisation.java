package com.am.konversion.domain;

import java.util.HashSet;
import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.am.konversion.domain.account.Account;

@Entity("organisation")
public class Organisation {

	@Id
	private String id;
	private String name;

	Set<Account> accounts = new HashSet<Account>();
	
	@Reference(lazy=true)
	Set<Order> orders = new HashSet<Order>();

	public Organisation(String id, String name, Set<Account> accounts, Set<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
		this.orders = orders;
	}

	public Organisation() {
		super();
	}
	
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", name=" + name + ", accounts=" + accounts + ", orders=" + orders + "]";
	}

}
