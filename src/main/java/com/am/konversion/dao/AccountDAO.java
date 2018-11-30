package com.am.konversion.dao;

import com.am.konversion.domain.Account;
import com.am.konversion.domain.AdwordsAccount;
import com.am.konversion.utils.Utils;

public class AccountDAO {
    
    public static void createAccount(Account account) {
	if (account instanceof AdwordsAccount 
		&& Utils.validateAdwordsAccountId(account.getId()))
	    return;
	    
	Utils.getDatastore().save(account);
    }

}
