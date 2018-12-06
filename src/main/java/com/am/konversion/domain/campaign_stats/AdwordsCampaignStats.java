package com.am.konversion.domain.campaign_stats;

import java.util.Date;

public class AdwordsCampaignStats extends CampaignStats {

    public AdwordsCampaignStats() {
	super();
    }

    public AdwordsCampaignStats(Date date, int impressions, int clicks, int conversions, double cost,
	    double impression_share) {
	super(date, impressions, clicks, conversions, cost, impression_share);
    }
}
