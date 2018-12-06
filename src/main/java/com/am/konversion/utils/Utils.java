package com.am.konversion.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
	
	public static void generateStats(LocalDate date_debut, LocalDate date_fin) {
		for (LocalDate date = date_debut; date.isBefore(date_fin); date = date.plusDays(1))
		{
			Random r = new Random();
			int low = 1;
			int high = 10;
			int result = r.nextInt(high-low) + low;
			Account temp;
			getAllAccount();
		}
	}

	public static List<DBObject> getAllAccount() {
		return ds.getCollection(Account.class).find(new BasicDBObject()).toArray();
	}
	
    
    public static void test() {
    	List<Account> test = ds.createQuery(Account.class).asList();
    	for (Account account : test) {
			System.out.println("HAHA + " + account.getName());
		}
    }
	
}
