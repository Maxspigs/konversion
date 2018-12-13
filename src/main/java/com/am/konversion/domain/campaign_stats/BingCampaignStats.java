package com.am.konversion.domain.campaign_stats;

import java.time.LocalDate;

public class BingCampaignStats extends CampaignStats {

    public BingCampaignStats() {
	super();
    }

    public BingCampaignStats(LocalDate date, int impressions, int clicks, int conversions, double cost,
	    double impression_share) {
	super(date, impressions, clicks, conversions, cost, impression_share);
    }
}
