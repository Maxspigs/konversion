package com.am.konversion.domain.campaign;

import com.am.konversion.domain.enum_konversion.Language;

public class BingCampaign extends Campaign {

    public BingCampaign() {
	super();
    }

    public BingCampaign(String _id, String name, Language language, double bid, double budget) {
	super(_id, name, language, bid, budget);
    }

}
