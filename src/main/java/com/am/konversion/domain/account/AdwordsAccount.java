package com.am.konversion.domain.account;

import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.ValidateUtils;

public class AdwordsAccount extends Account {

    public static final String ID_PATTERN = "\\d{3}[\\-]\\d{3}[\\-]\\d{4}";

    @SuppressWarnings("unused")
    private AdwordsAccount() {
	super();
    }

    public AdwordsAccount(String id) throws Exception {
	super(id);
    }

    public AdwordsAccount(String id, String name, Country country, Currency currency) throws Exception {
	super(id, name, country, currency);
    }

    @Override
    protected void setId(String id) throws Exception {
	if (!ValidateUtils.validateAccountId(id, ID_PATTERN))
	    throw new Exception("Id must be xxx-xxx-xxxx format");

	this._id = id;
    }

}
