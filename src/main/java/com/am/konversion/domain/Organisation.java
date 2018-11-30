package com.am.konversion.domain;

import java.util.HashSet;
import java.util.Set;

import com.am.konversion.domain.account.Account;

public class Organisation {

	private String id;
	private String name;
	
	Set<Account> accounts = new HashSet<Account>();
	
}
