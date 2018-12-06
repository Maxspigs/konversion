package com.am.konversion.dao;

import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.utils.DatastoreUtils;
import com.mongodb.WriteResult;

public class AccountDAO {

    public static Account createAccount(Account account) {
	try {
	    Key<Account> key = DatastoreUtils.getDatastore().save(account);
	    return findById(key.getId().toString());
	} catch (Exception e) {
	    System.err.println("Can't save Account in database : " + e.getMessage());
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

    /*public static Account addCampaignToAccount(Account account, Campaign campaign) {
	try {
	    Query<Account> search = Utils.getDatastore().find(Account.class).field("_id").equal(account.getId());

	    UpdateOperations<Account> newDoc = Utils.getDatastore().createUpdateOperations(Account.class)
		    .addToSet("campaigns", campaign);

	    Utils.getDatastore().update(search, newDoc);
	    
	    return findById(account.getId());
	} catch (Exception e) {
	    System.err.println("Can't add campaign to account : " + e.getMessage());
	    return null;
	}
    }*/

    public static boolean deleteAccount(Account account) {
	try {
	    WriteResult result = DatastoreUtils.getDatastore().delete(account);
	    return result.getN() > 0 ? true : false;
	} catch (Exception e) {
	    System.err.println("Can't delete Account in database : " + e.getMessage());
	    return false;
	}
    }

}
