package com.am.konversion;

import java.time.LocalDate;
import java.time.Month;

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

		

		CommandLineParser parser = new DefaultParser();

		// create the Options
		Options options = new Options();
		options.addOption("a", "action", true, "Choose delete or load");
		options.addOption("f", "filename", true, "/path/to/your/file");
		options.addOption("t", "type", true, "Choose between Account or Organisation.");
		options.addOption("d", "date_start", true, "Enter a date YYYY/MM/DD");

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
			} else if (line.getOptionValue("a").equalsIgnoreCase("generate") && line.hasOption("d")
					|| line.hasOption("date_start") && line.hasOption("d")) {
				String[] test = line.getOptionValues("d").toString().split("/");
				DatastoreUtils.generateStats(LocalDate.of(Integer.parseInt(test[0]), Month.of(Integer.parseInt(test[1])), Integer.parseInt(test[2])) , LocalDate.now().minusDays(1));
			}
		}
	}

}
