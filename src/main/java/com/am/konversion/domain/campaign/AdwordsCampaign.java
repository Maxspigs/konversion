package com.am.konversion.domain.campaign;

import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.domain.enum_konversion.SpendPattern;

public class AdwordsCampaign extends Campaign {

    private SpendPattern spendPattern;
    
    protected AdwordsCampaign() {
	super();
    }

    public AdwordsCampaign(String id) {
	super(id);
    }

    public AdwordsCampaign(String id, String name, Language language, double bid, double budget,
	    SpendPattern spendPattern) {
	super(id, name, language, bid, budget);
	this.spendPattern = spendPattern;
    }

    public SpendPattern getSpendPattern() {
	return spendPattern;
    }

    public void setSpendPattern(SpendPattern spendPattern) {
	this.spendPattern = spendPattern;
    }

}
