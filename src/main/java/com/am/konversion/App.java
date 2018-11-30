package com.am.konversion;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.Utils;

public class App {

	public static void main(String[] args) throws Exception {
		Utils.createDatastore();

		AdwordsAccount ac = new AdwordsAccount();
		ac.setCountry(Country.CA);
		ac.setCurrency(Currency.CAD);
		ac.setName("annie");
		ac.setId("123-454-1245");

		AccountDAO.createAccount(ac);
		//Utils.deleteDatabase();
	}

}
