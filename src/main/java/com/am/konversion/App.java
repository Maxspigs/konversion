package com.am.konversion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.campaign_stats.CampaignStats;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.utils.Utils;

public class App {

	public static void main(String[] args) throws Exception {
		Utils.createDatastore();

		AdwordsAccount ac = new AdwordsAccount();
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
		campaignStats.setClicks(100);
		campaignStats.setConversions(10);
		campaignStats.setCost(200.00);
		campaignStats.setDate(new Date());
		campaignStats.setImpression_share(0.93);
		campaignStats.setImpressions(100);
		
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
		//AccountDAO.createAccount(ab);
		Utils.deleteDatabase();
	}

}
