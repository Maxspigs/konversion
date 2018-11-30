package com.am.konversion.domain.account;

import java.util.Set;

import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.Utils;

public class AdwordsAccount extends Account {
	
	public static final String ID_PATTERN = "\\d{3}[\\-]\\d{3}[\\-]\\d{4}";
	
	public AdwordsAccount() {
		super();
	}
	
	public AdwordsAccount(String id, String name, Country country, Currency currency, Set<Campaign> compaigns) throws Exception {
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
