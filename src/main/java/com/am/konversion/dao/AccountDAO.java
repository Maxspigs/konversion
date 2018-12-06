package com.am.konversion.dao;

import org.mongodb.morphia.Key;

import com.am.konversion.domain.account.Account;
import com.am.konversion.utils.Utils;
import com.mongodb.WriteResult;

public class AccountDAO {

    public static Account createAccount(Account account) {
	try {
	    Key<Account> key = Utils.getDatastore().save(account);
	    return Utils.getDatastore().get(Account.class, key.getId());
	} catch (Exception e) {
	    System.err.println("Can't save Account in database : " + e.getMessage());
	    return null;
	}
    }

    public static boolean deleteAccount(Account account) {
	try {
	    WriteResult result = Utils.getDatastore().delete(account);
	    return result.getN() > 0 ? true : false;
	} catch (Exception e) {
	    System.out.println("Can't delete Account in database : " + e.getMessage());
	    return false;
	}
    }

}
