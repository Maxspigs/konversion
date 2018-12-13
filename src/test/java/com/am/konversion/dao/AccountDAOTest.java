package com.am.konversion.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;
import com.am.konversion.domain.enum_konversion.Country;
import com.am.konversion.domain.enum_konversion.Currency;
import com.am.konversion.utils.DatastoreUtils;

public class AccountDAOTest {
    private AdwordsAccount adwordsAccount;
    private BingAccount bingAccount;
    
    @Before
    public void setUp() throws Exception {	
	adwordsAccount = new AdwordsAccount("123-456-7890", "google pub", Country.CA, Currency.CAD);
	bingAccount = new BingAccount("1234567890", "bing pub", Country.US, Currency.USD);
    }
    
    @After
    public void tearDown() {
	adwordsAccount = null;
	bingAccount = null;
	
	DatastoreUtils.deleteAllTables();
    }
    
    @Test
    public void testSaveAdwordsAccount() {
	assertNotNull(AccountDAO.saveAccount(adwordsAccount));
    }
    
    @Test
    public void testSaveBingAccount() {
	assertNotNull(AccountDAO.saveAccount(bingAccount));
    }
    
    @Test
    public void testFindAdwordsAccountById() {
	Account save = AccountDAO.saveAccount(adwordsAccount);
	Account result = AccountDAO.findById(save.getId());
	assertEquals(save.getId(), result.getId());
    }
    
    @Test
    public void testFindBingAccountById() {
	Account save = AccountDAO.saveAccount(bingAccount);
	Account result = AccountDAO.findById(save.getId());
	assertEquals(save.getId(), result.getId());
    }
    
    @Ignore
    public void deleteAdwordsAccount() {
	AccountDAO.saveAccount(adwordsAccount);
	assertTrue(AccountDAO.deleteAccount(adwordsAccount));
    }
    
    @Ignore
    public void deleteAdwordsAccountNotInDatabase() {
	assertFalse(AccountDAO.deleteAccount(adwordsAccount));
    }
    
    @Ignore
    public void deleteBingAccount() {
	AccountDAO.saveAccount(bingAccount);
	assertTrue(AccountDAO.deleteAccount(bingAccount));
    }
    
    @Ignore
    public void deleteBingAccountNotInDatabase() {
	assertFalse(AccountDAO.deleteAccount(bingAccount));
    }

}
