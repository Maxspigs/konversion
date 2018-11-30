package com.am.konversion.domain.account;

import java.util.Set;

import com.am.konversion.domain.Campaign;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.Utils;

public class BingAccount extends Account {
	
	public static final String ID_PATTERN = "\\d+";
	
	public BingAccount() {
		super();
	}

	public BingAccount(String id, String name, Country country, Currency currency, Set<Campaign> compaigns) throws Exception {
		super();
		this.setId(id);
		this.name = name;
		this.country = country;
		this.currency = currency;
		this.compaigns = compaigns;
	}

	@Override
	public void setId(String id) throws Exception {
		if(!Utils.validateAccountId(id, ID_PATTERN)) {
			throw new Exception();
		}
		this._id = id;
	}

}
