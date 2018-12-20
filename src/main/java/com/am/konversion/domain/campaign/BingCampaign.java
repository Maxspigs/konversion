package com.am.konversion.domain.campaign;

import com.am.konversion.domain.enum_konversion.Language;

public class BingCampaign extends Campaign {
    
    protected BingCampaign() {
	super();
    }

    public BingCampaign(String id) {
	super(id);
    }

    public BingCampaign(String id, String name, Language language, double bid, double budget) {
	super(id, name, language, bid, budget);
    }

}
