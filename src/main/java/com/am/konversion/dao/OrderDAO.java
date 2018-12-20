package com.am.konversion.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.aggregation.Projection;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.am.konversion.domain.Order;
import com.am.konversion.domain.Organisation;
import com.am.konversion.utils.DatastoreUtils;

public class OrderDAO {

    public static Organisation addOrderToOrganisation(Organisation organisation, Order order) {
	try {
	    Query<Organisation> query = DatastoreUtils.getDatastore().find(Organisation.class).field("_id")
		    .equal(organisation.getId());

	    UpdateOperations<Organisation> update = DatastoreUtils.getDatastore().createUpdateOperations(Organisation.class)
		    .addToSet("orders", order);

	    DatastoreUtils.getDatastore().update(query, update);
	    return OrganisationDAO.findById(organisation.getId());
	} catch (Exception e) {
	    System.err.println("Can't add campaign : " + e.getMessage());
	    return null;
	}
    }
    
    public static Order updateOrder(Order order) {
	try {
	    Query<Organisation> query = DatastoreUtils.getDatastore().find(Organisation.class).field("orders.name")
		    .equal(order.getName());

	    UpdateOperations<Organisation> update = DatastoreUtils.getDatastore().createUpdateOperations(Organisation.class)
		    .set("orders.$.name", order.getName())
		    .set("orders.$.start_Date", order.getStart_Date())
		    .set("orders.$.end_date", order.getEnd_date())
		    .set("orders.$.budget", order.getBudget());
	    
	    UpdateResults result = DatastoreUtils.getDatastore().update(query, update);
	    
	    return result.getUpdatedCount() == 1 ? findByName(order.getName()) : null;
	} catch (Exception e) {
	    System.err.println("Can't update Campaign in database : " + e.getMessage());
	    return null;
	}
    }

    public static Order findByName(String name) {
	try {
	    List<Order> orders = new ArrayList<Order>();
	    DatastoreUtils.getDatastore().createAggregation(Organisation.class)
		    .unwind("orders")
		    .match(DatastoreUtils.getDatastore().find(Organisation.class).field("orders.name").equal(name))
		    .project(
			    Projection.projection("className", "orders.className"),
			    Projection.projection("name", "orders.name"),
			    Projection.projection("start_Date", "orders.start_Date"),
			    Projection.projection("end_date", "orders.end_date"),
			    Projection.projection("budget", "orders.budget"))
		    .aggregate(Order.class).forEachRemaining(orders::add);
	    
	    return orders.size() == 1 ? orders.get(0) : null;
	} catch (Exception e) {
	    System.err.println("Can't find order : " + e.getMessage());
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
