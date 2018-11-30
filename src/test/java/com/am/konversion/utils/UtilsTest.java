package com.am.konversion.utils;

import junit.framework.TestCase;

public class UtilsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPatternValidation() {
		boolean patate = Utils.validateAdwordsAccountId("123-456-7898");
		assertTrue(patate);
	}
	


}
