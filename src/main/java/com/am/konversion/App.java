package com.am.konversion;

import java.util.regex.Pattern;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.am.konversion.domain.AdwordsAccount;
import com.am.konversion.domain.Country;
import com.am.konversion.domain.Currency;
import com.mongodb.MongoClient;

public class App 
{
    public static void main( String[] args )
    {
    	Morphia morphia = new Morphia();
    	MongoClient client = new MongoClient("localhost", 27017);
    	Datastore ds = morphia.createDatastore(client, "Konversion");    	 	
    	
    	AdwordsAccount ac = new AdwordsAccount();
    	ac.setCountry(Country.CA);
    	ac.setCurrency(Currency.CAD);
    	ac.setName("max");
    	ac.setId("max");
    	ds.save(ac);
    	
    	/*
    	String pattern = "\\d{3}[\\-]\\d{3}[\\-]\\d{4}";
    	Pattern r = Pattern.compile(pattern);
    	*/
    	
    }
}
