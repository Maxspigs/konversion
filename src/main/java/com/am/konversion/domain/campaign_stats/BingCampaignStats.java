package com.am.konversion.domain.campaign_stats;

import java.util.Date;

public class BingCampaignStats extends CampaignStats {

    public BingCampaignStats() {
	super();
    }

    public BingCampaignStats(Date date, int impressions, int clicks, int conversions, double cost,
	    double impression_share) {
	super(date, impressions, clicks, conversions, cost, impression_share);
    }
}
