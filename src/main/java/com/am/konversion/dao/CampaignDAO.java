package com.am.konversion.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.aggregation.Projection;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.utils.CampaignValidation;
import com.am.konversion.utils.DatastoreUtils;

public class CampaignDAO {

    public static Account addCampaignToAccount(Account account, Campaign campaign) {
	try {
	    if (findById(campaign.get_id()) != null)
		throw new Exception("Campaign already exist. You should update it or use a different id.");
	    
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
    
    public static Campaign updateCampaign(Campaign campaign) {
	try {
	    Query<Account> query = DatastoreUtils.getDatastore().find(Account.class).field("campaigns._id")
		    .equal(campaign.get_id());

	    UpdateOperations<Account> update = DatastoreUtils.getDatastore().createUpdateOperations(Account.class)
		    .set("campaigns.$.name", campaign.getName())
		    .set("campaigns.$.language", campaign.getLanguage())
		    .set("campaigns.$.bid", campaign.getBid())
		    .set("campaigns.$.budget", campaign.getBudget());
	    
	    if (campaign instanceof AdwordsCampaign)
		update.set("campaigns.$.spendPattern", ((AdwordsCampaign)campaign).getSpendPattern());
	    
	    UpdateResults result = DatastoreUtils.getDatastore().update(query, update);
	    
	    return result.getUpdatedCount() == 1 ? findById(campaign.get_id()) : null;
	} catch (Exception e) {
	    System.err.println("Can't update Campaign in database : " + e.getMessage());
	    return null;
	}
    }

    public static Campaign findById(String id) {
	try {
	    List<Campaign> campaigns = new ArrayList<Campaign>();
	    DatastoreUtils.getDatastore().createAggregation(Account.class)
		    .unwind("campaigns")
		    .match(DatastoreUtils.getDatastore().find(Account.class).field("campaigns._id").equal(id))
		    .project(
			    Projection.projection("className", "campaigns.className"),
			    Projection.projection("_id", "campaigns._id"), 
			    Projection.projection("name", "campaigns.name"),
			    Projection.projection("language", "campaigns.language"),
			    Projection.projection("bid", "campaigns.bid"),
			    Projection.projection("budget", "campaigns.budget"),
			    Projection.projection("spendPattern", "campaigns.spendPattern"))
		    .aggregate(Campaign.class).forEachRemaining(campaigns::add);
	    
	    return campaigns.size() == 1 ? campaigns.get(0) : null;
	} catch (Exception e) {
	    System.err.println("Can't find campaign : " + e.getMessage());
	    e.printStackTrace();
	    return null;
	}
    }
    
//    public static boolean deleteCampaign(Campaign campaign) {
//	try {
//	    Query<Account> query = DatastoreUtils.getDatastore().find(Account.class).field("campaigns._id")
//		    .equal(campaign.get_id());
//
//	    UpdateOperations<Account> update = DatastoreUtils.getDatastore().createUpdateOperations(Account.class)
//		    .removeFirst("")
//	    
//	    UpdateResults result = DatastoreUtils.getDatastore().update(query, update);
//	    
//	    return true;
//	} catch (Exception e) {
//	    System.err.println("Can't delete campaign : " + e.getMessage());
//	    e.printStackTrace();
//	    return false;
//	}
//    }

}
