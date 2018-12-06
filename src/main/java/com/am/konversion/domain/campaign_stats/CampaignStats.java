package com.am.konversion.domain.campaign_stats;

import java.time.LocalDate;
import java.util.Date;

public class CampaignStats {

	protected LocalDate date;
	protected int impressions;
	protected int clicks;
	protected int conversions;
	protected double cost;
	protected double impression_share;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public void setClicks(int clicks) throws Exception {
		if(clicks < this.impressions)
			this.clicks = clicks;
		else {
			throw new Exception("Le nombre de clicks doit être inférieur au nombre d'impressions");
		}
	}

	public int getConversions() {
		return conversions;
	}

	public void setConversions(int conversions) throws Exception {
		if(conversions < this.clicks)
			this.conversions = conversions;
		else {
			throw new Exception("Le nombre de converions doit être inférieur au nombre de clicks");
		}
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getImpression_share() {
		return clicks / impressions;
	}
	
	public void setImpression_share(double impression_share) {
		this.impression_share = impression_share;
	}


}
