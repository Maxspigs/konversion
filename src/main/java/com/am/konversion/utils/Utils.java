package com.am.konversion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Utils {

    private static final String PATTERN = "\\d{3}[\\-]\\d{3}[\\-]\\d{4}";
    private static Datastore ds;

    public static void createDatastore() {
	Morphia morphia = new Morphia();
	MongoClient client = new MongoClient("localhost", 27017);
	ds = morphia.createDatastore(client, "Konversion");
    }
    
    public static Datastore getDatastore() {
	return ds;
    }

    public static boolean validateAdwordsAccountId(String id) {
	Pattern pattern = Pattern.compile(PATTERN);
	Matcher matcher = pattern.matcher(id);
	return matcher.find();
    }
}
