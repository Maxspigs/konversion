package com.am.konversion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

    public static boolean validateAccountId(String id, String regexPattern) {
	Pattern pattern = Pattern.compile(regexPattern);
	Matcher matcher = pattern.matcher(id);
	return matcher.find();
    }
    
}
