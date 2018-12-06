package com.am.konversion.domain.campaign;

import com.am.konversion.domain.enum_konversion.Language;
import com.am.konversion.domain.enum_konversion.SpendPattern;

public class AdwordsCampaign extends Campaign {
    
    private SpendPattern spendPattern;

    public AdwordsCampaign() {
	super();
    }

    public AdwordsCampaign(String _id, String name, Language language, double bid, double budget,
	    SpendPattern spendPattern) {
	super(_id, name, language, bid, budget);
	this.spendPattern = spendPattern;
    }

    public AdwordsCampaign(SpendPattern spendPattern) {
	super();
	this.spendPattern = spendPattern;
    }

    public SpendPattern getSpendPattern() {
        return spendPattern;
    }

    public void setSpendPattern(SpendPattern spendPattern) {
        this.spendPattern = spendPattern;
    }

}
