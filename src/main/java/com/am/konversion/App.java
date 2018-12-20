package com.am.konversion;

import java.time.LocalDate;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

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
import com.am.konversion.utils.DatastoreUtils;

public class App {

	public static void main(String[] args) throws Exception {

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
		campaignStats.setImpressions(100);
		campaignStats.setClicks(10);
		campaignStats.setConversions(5);
		campaignStats.setCost(200.00);
		campaignStats.setDate(LocalDate.now());
		campaignStats.setImpression_share(0.10);

		CampaignStats campaignStats2 = new AdwordsCampaignStats();
		campaignStats.setImpressions(300);
		campaignStats.setClicks(20);
		campaignStats.setConversions(6);
		campaignStats.setCost(650.00);
		campaignStats.setDate(LocalDate.now());
		campaignStats.setImpression_share(0.80);

		adwordsCampaign = CampaignStatsDAO.addCampaignStat(adwordsCampaign, campaignStats);
		adwordsCampaign = CampaignStatsDAO.addCampaignStat(adwordsCampaign, campaignStats2);

		Organisation adwordOrganisation = new Organisation("toto", "Toto Organisation");
		adwordOrganisation = OrganisationDAO.createOrganisation(adwordOrganisation);
		adwordOrganisation.setName("titty");
		adwordOrganisation = OrganisationDAO.updateOrganisation(adwordOrganisation);
		
		DatastoreUtils.saveAccount();
		DatastoreUtils.saveOrganisation();

		CommandLineParser parser = new DefaultParser();

		// create the Options
		Options options = new Options();
		options.addOption("a", "action", true, "Choose delete or load");
		options.addOption("f", "filename", true, "/path/to/your/file");
		options.addOption("t", "type", true, "Choose between Account or Organisation.");

		// parse the command line arguments
		CommandLine line = parser.parse(options, args);

		// validate that block-size has been set
		if (line.hasOption("a") || line.hasOption("action")) {
			if (line.getOptionValue("a").equalsIgnoreCase("delete")) {
				DatastoreUtils.deleteAllTables();
			} else if (line.getOptionValue("a").equalsIgnoreCase("load") && line.hasOption("f")
					|| line.hasOption("filename") && line.hasOption("t")) {
				if (line.getOptionValue("t").equals("Account")) {
					DatastoreUtils.loadAccount(line.getOptionValue("f"));
				} else if (line.getOptionValue("t").equals("Organisation")) {
					DatastoreUtils.loadOrganisation(line.getOptionValue("f"));
				}
			}
		}
	}

}
