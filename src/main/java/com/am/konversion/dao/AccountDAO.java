package com.am.konversion.dao;

import org.mongodb.morphia.Key;

import com.am.konversion.domain.account.Account;
import com.am.konversion.utils.Utils;

public class AccountDAO {
    
    public static Account createAccount(Account account) {
	try {
	    Key<Account> key = Utils.getDatastore().save(account);
	    return Utils.getDatastore().get(Account.class, key.getId());
	} catch (Exception e) {
	    System.err.println("Can't save Account in database : "
		    + e.getMessage());
	    return null;
	}
    }

}
