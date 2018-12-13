package com.am.konversion.domain.account;

import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.ValidateUtils;

public class BingAccount extends Account {

    public static final String ID_PATTERN = "^\\d+$";
    
    @SuppressWarnings("unused")
    private BingAccount() {
	super();
    }

    public BingAccount(String id) throws Exception {
	super(id);
    }

    public BingAccount(String id, String name, Country country, Currency currency) throws Exception {
	super(id, name, country, currency);
    }

    @Override
    protected void setId(String id) throws Exception {
	if (!ValidateUtils.validateAccountId(id, ID_PATTERN))
	    throw new Exception("Id must be only number");

	this._id = id;
    }

}
