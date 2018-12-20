package com.am.konversion.dao;

import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.am.konversion.domain.Organisation;
import com.am.konversion.utils.DatastoreUtils;
import com.mongodb.WriteResult;

public class OrganisationDAO {

    public static Organisation createOrganisation(Organisation organisation) {
	try {
	    if (findById(organisation.getId()) != null)
		throw new Exception("Organisation already exist. You should update it.");
	    
	    Key<Organisation> key = DatastoreUtils.getDatastore().save(organisation);
	    return findById(key.getId().toString());
	} catch (Exception e) {
	    System.err.println("Can't save Organisation in database : " + e.getMessage());
	    return null;
	}
    }
    
    public static Organisation updateOrganisation(Organisation organisation) {
	try {
	    Query<Organisation> query = DatastoreUtils.getDatastore().find(Organisation.class).field("_id")
		    .equal(organisation.getId());

	    UpdateOperations<Organisation> update = DatastoreUtils.getDatastore().createUpdateOperations(Organisation.class)
		    .set("name", organisation.getName());
	    
	    DatastoreUtils.getDatastore().update(query, update);
	    
	    return findById(organisation.getId());
	} catch (Exception e) {
	    System.err.println("Can't update organisation in database : " + e.getMessage());
	    return null;
	}
    }

    public static List<Organisation> find() {
	try {
	    return DatastoreUtils.getDatastore().find(Organisation.class).asList();
	} catch (Exception e) {
	    System.err.println("Can't find Organisations : " + e.getMessage());
	    return null;
	}
    }

    public static Organisation findById(String id) {
	try {
	    return DatastoreUtils.getDatastore().get(Organisation.class, id);
	} catch (Exception e) {
	    System.err.println("Can't find Organisation in database : " + e.getMessage());
	    return null;
	}
    }

    public static Organisation findByName(String name) {
	try {
	    return DatastoreUtils.getDatastore().find(Organisation.class).field("name").equal(name).get();
	} catch (Exception e) {
	    System.err.println("Can't find Organisation in database : " + e.getMessage());
	    return null;
	}
    }

    public static boolean deleteOrganisation(Organisation organisation) {
	try {
	    WriteResult result = DatastoreUtils.getDatastore().delete(organisation);
	    return result.getN() > 0 ? true : false;
	} catch (Exception e) {
	    System.err.println("Can't delete Organisation in database : " + e.getMessage());
	    return false;
	}
    }

}
