package com.am.konversion.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class DatastoreUtils {

    private static final String PATH_JSON = "C:\\Users\\annie\\Desktop\\Tech_Info\\json.json";
    private static MongoClient client;
    private static Datastore ds;

    public static void createDatastore() {
	Morphia morphia = new Morphia();
	client = new MongoClient("192.168.99.100", 32768);
	//client = new MongoClient("localhost", 27017);
	ds = morphia.createDatastore(client, "konversion");
    }

    public static Datastore getDatastore() {
	return ds;
    }

    public static void deleteAllTables() {
	ds.getCollection(Account.class).remove(new BasicDBObject());
    }

    public static void generateStats(LocalDate date_debut, LocalDate date_fin) {

    }

    public static List<DBObject> getAllAccount() {
	return ds.getCollection(Account.class).find(new BasicDBObject()).toArray();
    }

    public static void saveDocument() throws IOException {
	File file = new File(PATH_JSON);
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	Gson gson = new Gson();
	try {
	    String yourObjectJson = gson.toJson(getAllAccount());
	    fileOutputStream.write(yourObjectJson.getBytes());
	} catch (IOException e) {
	    System.out.println("Can't save document " + e.getMessage());
	} finally {
	    fileOutputStream.flush();
	    fileOutputStream.close();
	}
    } 
   
    public static void loadDocument() throws IOException {
	Gson gson = new Gson();
	String text = "";
	try {
	    File yourFile = new File(PATH_JSON);
	    InputStream inputStream = new FileInputStream(yourFile);
	    StringBuilder stringBuilder = new StringBuilder();
	    if (inputStream != null) {
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	        String receiveString = "";
	        while ((receiveString = bufferedReader.readLine()) != null){
	            stringBuilder.append(receiveString);
	        }
	        inputStream.close();
	        text = stringBuilder.toString();
	    }
	} catch (FileNotFoundException e) {
	    //Log your error with Log.e
	} catch (IOException e) {
	    //Log your error with Log.e
	}
	//Use Gson to recreate your Object from the text String
	List<Account> account = gson.fromJson(text, List.class);
	System.out.println("Sysout" + account);
    }

}
