package com.am.konversion.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	DatastoreUtils.createDatastore();	
	
	adwordsAccount = new AdwordsAccount("123-456-7890", "google pub", Country.CA, Currency.CAD, null);
	bingAccount = new BingAccount("1234567890", "bing pub", Country.US, Currency.USD, null);
    }
    
    @After
    public void tearDown() {
	adwordsAccount = null;
	bingAccount = null;
	
	DatastoreUtils.deleteAllTables();
    }
    
    @Test
    public void testCreateAdwordsAccount() {
	assertNotNull(AccountDAO.createAccount(adwordsAccount));
    }
    
    @Test(expected=Exception.class)
    public void testCreateAdwordsAccountBadID() throws Exception {
	adwordsAccount.setId("1234567891");
	AccountDAO.createAccount(adwordsAccount);
    }
    
    @Test
    public void testCreateBingAccount() {
	assertNotNull(AccountDAO.createAccount(bingAccount));
    }
    
    @Test(expected=Exception.class)
    public void testCreateBingAccountBadID() throws Exception {
	bingAccount.setId("123-456-7891");
	AccountDAO.createAccount(bingAccount);
    }
    
    @Test
    public void deleteAdwordsAccount() {
	AccountDAO.createAccount(adwordsAccount);
	assertTrue(AccountDAO.deleteAccount(adwordsAccount));
    }
    
    @Test
    public void deleteAdwordsAccountNotInDatabase() {
	assertFalse(AccountDAO.deleteAccount(adwordsAccount));
    }
    
    @Test
    public void deleteBingAccount() {
	AccountDAO.createAccount(bingAccount);
	assertTrue(AccountDAO.deleteAccount(bingAccount));
    }
    
    @Test
    public void deleteBingAccountNotInDatabase() {
	assertFalse(AccountDAO.deleteAccount(bingAccount));
    }

}
