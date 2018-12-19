package com.am.konversion.dao;

import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.am.konversion.domain.account.Account;
import com.am.konversion.utils.DatastoreUtils;
import com.mongodb.WriteResult;

public class AccountDAO {

    public static Account createAccount(Account account) {
	try {
	    if (findById(account.getId()) != null)
		throw new Exception("Account already exist. You should update it or use a different id.");

	    Key<Account> key = DatastoreUtils.getDatastore().save(account);
	    return findById(key.getId().toString());
	} catch (Exception e) {
	    System.err.println("Can't save Account in database : " + e.getMessage());
	    return null;
	}
    }

    public static Account updateAccount(Account account) {
	try {
	    Query<Account> query = DatastoreUtils.getDatastore().find(Account.class).field("_id")
		    .equal(account.getId());

	    UpdateOperations<Account> update = DatastoreUtils.getDatastore().createUpdateOperations(Account.class)
		    .set("name", account.getName())
		    .set("country", account.getCountry())
		    .set("currency", account.getCurrency());
	    
	    DatastoreUtils.getDatastore().update(query, update);
	    
	    return findById(account.getId());
	} catch (Exception e) {
	    System.err.println("Can't update Account in database : " + e.getMessage());
	    return null;
	}
    }

    public static List<Account> find() {
	try {
	    return DatastoreUtils.getDatastore().find(Account.class).asList();
	} catch (Exception e) {
	    System.err.println("Can't find Accounts : " + e.getMessage());
	    return null;
	}
    }

    public static Account findById(String id) {
	try {
	    return DatastoreUtils.getDatastore().get(Account.class, id);
	} catch (Exception e) {
	    System.err.println("Can't find Account in database : " + e.getMessage());
	    return null;
	}
    }

    public static boolean deleteAccount(Account account) {
	try {
	    WriteResult result = DatastoreUtils.getDatastore().delete(account);
	    return result.getN() == 1 ? true : false;
	} catch (Exception e) {
	    System.err.println("Can't delete Account in database : " + e.getMessage());
	    return false;
	}
    }

}
