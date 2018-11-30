package com.am.konversion.dao;

import com.am.konversion.domain.account.Account;
import com.am.konversion.utils.Utils;

public class AccountDAO {
    
    public static void createAccount(Account account) {   
		Utils.getDatastore().save(account);
    }
    
    

}
