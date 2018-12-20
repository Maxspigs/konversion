package com.am.konversion;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.BingCampaign;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.utils.Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.util.Util;

public class App {

    public static void main(String[] args) throws Exception {
	DatastoreUtils.deleteAllTables();

		Account ac = new AdwordsAccount();
		ac.setCountry(Country.CA);
		ac.setCurrency(Currency.CAD);
		ac.setName("annie");
		ac.setId("123-454-1245");
		
		AdwordsAccount ab = new AdwordsAccount();
		ab.setCountry(Country.CA);
		ab.setCurrency(Currency.CAD);
		ab.setName("max");
		ab.setId("123-312-2343");
		
		CampaignStats campaignStats = new CampaignStats();
		campaignStats.setImpressions(100);
		campaignStats.setClicks(30);
		campaignStats.setConversions(10);
		campaignStats.setImpression_share(campaignStats.getImpression_share());
		campaignStats.setCost(200.00);
		campaignStats.setDate(LocalDate.now());
		
		Campaign campaign = new Campaign();
		campaign.set_id("1");
		campaign.setBid(40.00);
		campaign.setBudget(10000.00);
		campaign.setLanguage(Language.FR);
		campaign.setName("Facilite");
		
		Set<CampaignStats> stats = new HashSet<CampaignStats>();
		stats.add(campaignStats);
		campaign.setStats(stats);
		
		Set<Campaign> campaigns = new HashSet<Campaign>();		
		campaigns.add(campaign);
		ac.setCompaigns(campaigns);
		
		AccountDAO.createAccount(ac);
		AccountDAO.createAccount(ab);
		Utils.test();
		
		/*
		List<Account> accounts = Utils.getAllAccount().;
		for (Account account : accounts) {
			System.out.println("Debut " + account.getName());
		}
		//Utils.deleteDatabase();
		*/
	}
	

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
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//	AdwordsAccount ac = new AdwordsAccount();
//	ac.setCountry(Country.CA);
//	ac.setCurrency(Currency.CAD);
//	ac.setName("annie");
//	ac.setId("123-454-1245");
//
//	AdwordsAccount ab = new AdwordsAccount();
//	ab.setCountry(Country.CA);
//	ab.setCurrency(Currency.CAD);
//	ab.setName("max");
//	ab.setId("123-312-1343");
//
//	CampaignStats campaignStats = new AdwordsCampaignStats();
//	campaignStats.setImpressions(100);
//	campaignStats.setClicks(10);
//	campaignStats.setConversions(5);
//	campaignStats.setCost(200.00);
//	campaignStats.setDate(LocalDate.now());
//	campaignStats.setImpression_share(0.10);
//	
//	CampaignStats campaignStats2 = new AdwordsCampaignStats();
//	campaignStats.setImpressions(300);
//	campaignStats.setClicks(20);
//	campaignStats.setConversions(6);
//	campaignStats.setCost(650.00);
//	campaignStats.setDate(LocalDate.now());
//	campaignStats.setImpression_share(0.80);
//	
//
//	Campaign campaign = new AdwordsCampaign();
//	campaign.set_id("1");
//	campaign.setBid(40.00);
//	campaign.setBudget(10000.00);
//	campaign.setLanguage(Language.FR);
//	campaign.setName("Facilite");
//
//	Set<CampaignStats> stats = new HashSet<CampaignStats>();
//	stats.add(campaignStats);
//	stats.add(campaignStats2);
//	campaign.setStats(stats);
//
//	Set<Campaign> campaigns = new HashSet<Campaign>();
//	campaigns.add(campaign);
//	ac.setCampaigns(campaigns);
//
//	Account account = AccountDAO.createAccount(ac);
//	System.out.println(account);
//	
//	Campaign campaign2 = new AdwordsCampaign();
//	campaign2.set_id("2");
//	campaign2.setBid(40);
//	campaign2.setBudget(20000);
//	campaign2.setLanguage(Language.EN);
//	campaign2.setName("UMAknow");
//	
//	campaigns.add(campaign2);
//	account.setCampaigns(campaigns);
//	
//	account = AccountDAO.createAccount(account);
//	AccountDAO.createAccount(ab);
//	
//	Organisation organisation = new Organisation();
//	organisation.setName("INTACT");

	// DatastoreUtils.getDatastore().save(organisation);

	// DatastoreUtils.saveDocument();

	// DatastoreUtils.loadDocument();

	// AccountDAO.deleteAccount(account);

	// Utils.deleteDatabase();

    }

}
