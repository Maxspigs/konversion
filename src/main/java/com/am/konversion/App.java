package com.am.konversion;

import com.am.konversion.dao.AccountDAO;
import com.am.konversion.domain.AdwordsAccount;
import com.am.konversion.domain.Country;
import com.am.konversion.domain.Currency;
import com.am.konversion.utils.Utils;

public class App {
    
    public static void main(String[] args) {
	Utils.createDatastore();
	
	AdwordsAccount ac = new AdwordsAccount();
	ac.setCountry(Country.CA);
	ac.setCurrency(Currency.CAD);
	ac.setName("max");
	ac.setId("max");
	
	AccountDAO.createAccount(ac);
    }
}
