package com.am.konversion.dao;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.utils.CampaignValidation;
import com.am.konversion.utils.DatastoreUtils;

public class CampaignDAO {

    public static Account addCampaignToAccount(Account account, Campaign campaign) {
	try {
	    if (!CampaignValidation.isSamePlatform(account, campaign))
		throw new Exception("account & campaign doesn't match platform");
	    
	    Query<Account> query = DatastoreUtils.getDatastore().find(Account.class).field("_id")
		    .equal(account.getId());

	    UpdateOperations<Account> update = DatastoreUtils.getDatastore().createUpdateOperations(Account.class)
		    .addToSet("campaigns", campaign);

	    DatastoreUtils.getDatastore().update(query, update);
	    return AccountDAO.findById(account.getId());
	} catch (Exception e) {
	    System.err.println("Can't add campaign : " + e.getMessage());
	    return account;
	}
    }

}
