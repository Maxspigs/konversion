package com.am.konversion.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.am.konversion.domain.account.AdwordsAccount;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class Utils {

	private static MongoClient client;
	private static Datastore ds;
	
	public static void createDatastore() {
		Morphia morphia = new Morphia();
		client = new MongoClient("192.168.99.100", 32768);
		// client = new MongoClient("localhost", 27017);
		ds = morphia.createDatastore(client, "konversion");
	}

	public static Datastore getDatastore() {
		return ds;
	}

	public static boolean validateAccountId(String id, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(id);
		return matcher.find();
	}
	
	public static void deleteDatabase() {
		ds.getCollection(AdwordsAccount.class).remove(new BasicDBObject());
	}	
	
	public static void generateStats(Date date_debut, Date date_fin) {
	}
	
}
