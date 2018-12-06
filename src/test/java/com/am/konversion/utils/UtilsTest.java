package com.am.konversion.utils;

import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;

import junit.framework.TestCase;

public class UtilsTest extends TestCase {

    protected void setUp() throws Exception {
	super.setUp();
    }

    protected void tearDown() throws Exception {
	super.tearDown();
    }

    public void testPatternAdwordsValidation() {
	boolean patate = Utils.validateAccountId("123-456-7898", AdwordsAccount.ID_PATTERN);
	assertTrue(patate);
    }

    public void testPatternAdwordsValidationFail() {
	boolean patate = Utils.validateAccountId("BOB", AdwordsAccount.ID_PATTERN);
	assertFalse(patate);
    }

    public void testPatternBingValidation() {
	boolean patate = Utils.validateAccountId("123456789", BingAccount.ID_PATTERN);
	assertTrue(patate);
    }

    public void testPatternBingValidationFail() {
	boolean patate = Utils.validateAccountId("annie", BingAccount.ID_PATTERN);
	assertFalse(patate);
    }

}
