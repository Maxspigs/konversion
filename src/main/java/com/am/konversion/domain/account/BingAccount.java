package com.am.konversion.domain.account;

import java.util.Set;

import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.DatastoreUtils;
import com.am.konversion.utils.ValidateUtils;

public class BingAccount extends Account {

    public static final String ID_PATTERN = "^\\d+$";

    public BingAccount() {
	super();
    }

    public BingAccount(String _id, String name, Country country, Currency currency, Set<Campaign> campaigns) throws Exception {
	super(_id, name, country, currency, campaigns);
    }

    @Override
    public void setId(String id) throws Exception {
	if (!ValidateUtils.validateAccountId(id, ID_PATTERN))
	    throw new Exception("Id must be only number");

	this._id = id;
    }

}
