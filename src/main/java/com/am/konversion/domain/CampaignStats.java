package com.am.konversion.domain;

import java.sql.Date;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class CampaignStats {

	protected Date date;
	protected int impressions;
	protected int click;
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

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
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
