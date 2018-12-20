package com.am.konversion.dao;

import java.util.List;

import org.mongodb.morphia.Key;

import com.am.konversion.domain.Organisation;
import com.am.konversion.utils.DatastoreUtils;
import com.mongodb.WriteResult;

public class OrganisationDAO {

	public static Organisation createOrganisation(Organisation organisation) {
		try {
		    Key<Organisation> key = DatastoreUtils.getDatastore().save(organisation);
		    return findById(key.getId().toString());
		} catch (Exception e) {
		    System.err.println("Can't save Organisation in database : " + e.getMessage());
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
