package com.am.konversion.domain.campaign_stats;

import java.time.LocalDate;

public class AdwordsCampaignStats extends CampaignStats {

    public AdwordsCampaignStats() {
	super();
    }

    public AdwordsCampaignStats(LocalDate date, int impressions, int clicks, int conversions, double cost,
	    double impression_share) {
	super(date, impressions, clicks, conversions, cost, impression_share);
    }
}
