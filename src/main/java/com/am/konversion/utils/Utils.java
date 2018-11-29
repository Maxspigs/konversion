package com.am.konversion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	
	private static final String PATTERN = "\\d{3}[\\-]\\d{3}[\\-]\\d{4}";
	
	public static boolean patternValidation(String id) {
		// create a pattern
	    Pattern pattern = Pattern.compile(PATTERN);
	    // get a matcher object
	    Matcher matcher = pattern.matcher(id);
	    
	    if(matcher.find()) {
	    	return true;
	    }
	    return false;
	}
}
