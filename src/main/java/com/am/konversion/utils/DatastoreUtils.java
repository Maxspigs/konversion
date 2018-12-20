package com.am.konversion.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.dao.CampaignDAO;
import com.am.konversion.dao.CampaignStatsDAO;
import com.am.konversion.dao.OrganisationDAO;
import com.am.konversion.domain.Organisation;
import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.BingCampaign;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.campaign_stats.AdwordsCampaignStats;
import com.am.konversion.domain.campaign_stats.CampaignStats;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.domain.enum_konversion.SpendPattern;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DatastoreUtils {

	private static final String ACCOUNT_JSON = "./Account.json";
	private static final String ORGANISATION_JSON = "./Organisation.json";
    private static MongoClient client;
    private static Datastore ds;
    
    private static void createDatastore() {
	Morphia morphia = new Morphia();
	 client = new MongoClient("192.168.99.100", 32769);
	//client = new MongoClient("localhost", 27017);
	ds = morphia.createDatastore(client, "konversion");	
    }

    public static Datastore getDatastore() {
	if (ds == null)
	    createDatastore();
	
	return ds;
    }
    
    public static DBCollection getAccountTable() {
	return getDatastore().getCollection(Account.class);
    }
    
    public static DBCollection getOrganisationTable() {
	return getDatastore().getCollection(Organisation.class);
    }

    public static void deleteAllTables() {
	getAccountTable().remove(new BasicDBObject());
	getOrganisationTable().remove(new BasicDBObject());
    }

    public static void generateStats(LocalDate date_debut, LocalDate date_fin) throws Exception {
    	for(LocalDate date = date_debut; date.isBefore(date_fin); date = date.plusDays(1)) {
    		DatastoreUtils.deleteAllTables();

    		Account adwords = new AdwordsAccount("123-456-7890", "My Adwords Account", Country.CA, Currency.CAD);
    		Account bing = new BingAccount("123", "My Bing Account", Country.US, Currency.USD);

    		adwords = AccountDAO.createAccount(adwords);
    		bing = AccountDAO.createAccount(bing);

    		adwords.setName("Adwords Account");
    		adwords = AccountDAO.updateAccount(adwords);

    		bing.setCountry(Country.CA);
    		bing.setCurrency(Currency.CAD);
    		bing = AccountDAO.updateAccount(bing);

    		Account test = new AdwordsAccount("147-852-3690");
    		test = AccountDAO.createAccount(test);
    		AccountDAO.deleteAccount(test);

    		Campaign adwordsCampaign = new AdwordsCampaign("123", "My adwords campaign", Language.FR, 20, 10000,
    				SpendPattern.ALAP);
    		Campaign adwordsCampaign2 = new AdwordsCampaign("456", "My adwords campaign 2", Language.EN, 60, 200000,
    				SpendPattern.ASAP);
    		Campaign bingCampaign = new BingCampaign("231", "My bing campaign", Language.EN, 40, 10000);

    		adwords = CampaignDAO.addCampaignToAccount(adwords, adwordsCampaign);
    		adwords = CampaignDAO.addCampaignToAccount(adwords, adwordsCampaign2);
    		bing = CampaignDAO.addCampaignToAccount(bing, bingCampaign);

    		adwordsCampaign.setBid(25.50);
    		adwordsCampaign.setLanguage(Language.EN);
    		adwordsCampaign = CampaignDAO.updateCampaign(adwordsCampaign);

    		CampaignStats campaignStats = new AdwordsCampaignStats();
    		campaignStats.setImpressions(randomStats(10000, 1000));
    		campaignStats.setClicks(randomStats(campaignStats.getImpressions()-1000, 100));
    		campaignStats.setConversions(randomStats(campaignStats.getClicks()-100, 10));
    		campaignStats.setCost(randomStats(1000, 100));
    		campaignStats.setDate(date);
    		campaignStats.setImpression_share(0.10);

    		CampaignStats campaignStats2 = new AdwordsCampaignStats();
    		campaignStats2.setImpressions(randomStats(10000, 1000));
    		campaignStats2.setClicks(randomStats(campaignStats2.getImpressions()-1000, 100));
    		campaignStats2.setConversions(randomStats(campaignStats2.getClicks()-100, 10));
    		campaignStats2.setCost(randomStats(1000, 100));
    		campaignStats2.setDate(date);
    		campaignStats2.setImpression_share(0.15);

    		adwordsCampaign = CampaignStatsDAO.addCampaignStat(adwordsCampaign, campaignStats);
    		adwordsCampaign = CampaignStatsDAO.addCampaignStat(adwordsCampaign, campaignStats2);

    		Organisation adwordOrganisation = new Organisation("toto" + randomStats(1000000, 0), "Toto Organisation");
    		adwordOrganisation = OrganisationDAO.createOrganisation(adwordOrganisation);
    		adwordOrganisation.setName("titty");
    		adwordOrganisation = OrganisationDAO.updateOrganisation(adwordOrganisation);
    		
    		DatastoreUtils.saveAccount();
    		DatastoreUtils.saveOrganisation();
    	}
    }

    public static int randomStats(int range, int min) {
    	return (int)(Math.random() * range) + min; 
    }
    
    public static void saveAccount() throws IOException {
		File file = new File(ACCOUNT_JSON);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Gson gson = new Gson();
		try {
			String yourObjectJson = gson.toJson(AccountDAO.find());
			fileOutputStream.write(yourObjectJson.getBytes());
		} catch (IOException e) {
			System.out.println("Can't save document " + e.getMessage());
		} finally {
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}

	public static void saveOrganisation() throws IOException {
		File file = new File(ORGANISATION_JSON);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Gson gson = new Gson();
		try {
			String yourObjectJson = gson.toJson(AccountDAO.find());
			fileOutputStream.write(yourObjectJson.getBytes());
		} catch (IOException e) {
			System.out.println("Can't save document " + e.getMessage());
		} finally {
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}

	public static void loadAccount(String path) throws IOException {
		Gson gson = new Gson();
		String text = "";
		try {
			File yourFile = new File(path);
			InputStream inputStream = new FileInputStream(yourFile);
			StringBuilder stringBuilder = new StringBuilder();
			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}
				inputStream.close();
				text = stringBuilder.toString();
			}
		} catch (FileNotFoundException e) {
			// Log your error with Log.e
		} catch (IOException e) {
			// Log your error with Log.e
		}
		// Use Gson to recreate your Object from the text String
		List<Account> account = gson.fromJson(text, List.class);
		System.out.println("Sysout" + account);
	}

	public static void loadOrganisation(String path) throws IOException {
		Gson gson = new Gson();
		String text = "";
		try {
			File yourFile = new File(path);
			InputStream inputStream = new FileInputStream(yourFile);
			StringBuilder stringBuilder = new StringBuilder();
			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}
				inputStream.close();
				text = stringBuilder.toString();
			}
		} catch (FileNotFoundException e) {
			// Log your error with Log.e
		} catch (IOException e) {
			// Log your error with Log.e
		}
		// Use Gson to recreate your Object from the text String
		List<Organisation> organisation = gson.fromJson(text, List.class);
		System.out.println("Sysout" + organisation);
	}

}
