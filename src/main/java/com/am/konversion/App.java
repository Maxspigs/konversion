package com.am.konversion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.dao.OrganisationDAO;
import com.am.konversion.domain.Organisation;
import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.campaign_stats.AdwordsCampaignStats;
import com.am.konversion.domain.campaign_stats.CampaignStats;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.utils.DatastoreUtils;

public class App {

    public static void main(String[] args) throws Exception {
	DatastoreUtils.createDatastore();

	AdwordsAccount ac = new AdwordsAccount();
	ac.setCountry(Country.CA);
	ac.setCurrency(Currency.CAD);
	ac.setName("annie");
	ac.setId("123-454-1245");

	AdwordsAccount ab = new AdwordsAccount();
	ab.setCountry(Country.CA);
	ab.setCurrency(Currency.CAD);
	ab.setName("max");
	ab.setId("123-312-1343");

	CampaignStats campaignStats = new AdwordsCampaignStats();
	campaignStats.setImpressions(100);
	campaignStats.setClicks(10);
	campaignStats.setConversions(5);
	campaignStats.setCost(200.00);
	campaignStats.setDate(new Date());
	campaignStats.setImpression_share(0.10);
	

	Campaign campaign = new AdwordsCampaign();
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
	ac.setCampaigns(campaigns);

	Account account = AccountDAO.createAccount(ac);
	System.out.println(account);
	
	Campaign campaign2 = new AdwordsCampaign();
	campaign2.set_id("2");
	campaign2.setBid(40);
	campaign2.setBudget(20000);
	campaign2.setLanguage(Language.EN);
	campaign2.setName("UMAknow");
	
	campaigns.add(campaign2);
	account.setCampaigns(campaigns);
	
	account = AccountDAO.createAccount(account);
	AccountDAO.createAccount(ab);
	
	Organisation organisation = new Organisation();
	organisation.setName("INTACT");
	
	DatastoreUtils.getDatastore().save(organisation);
	
	
	
	//DatastoreUtils.saveDocument();
	
	//DatastoreUtils.loadDocument();

	// AccountDAO.deleteAccount(account);

	
	// Utils.deleteDatabase();
	
	
    }

}
