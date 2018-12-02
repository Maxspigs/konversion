package com.am.konversion.domain.campaign_stats;

import java.util.Date;

public class CampaignStats {

	protected Date date;
	protected int impressions;
	protected int clicks;
	protected int conversions;
	protected double cost;
	protected double impression_share;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getImpressions() {
		return impressions;
	}

	public void setImpressions(int impressions) {
		this.impressions = impressions;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getConversions() {
		return conversions;
	}

	public void setConversions(int conversions) {
		this.conversions = conversions;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getImpression_share() {
		return impression_share;
	}

	public void setImpression_share(double impression_share) {
		this.impression_share = impression_share;
	}

}
