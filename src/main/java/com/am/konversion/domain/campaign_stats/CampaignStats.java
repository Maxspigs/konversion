package com.am.konversion.domain.campaign_stats;

import java.time.LocalDate;

import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

public abstract class CampaignStats {

    @Indexed(options = @IndexOptions(unique=true))
    protected LocalDate date;
    protected int impressions;
    protected int clicks;
    protected int conversions;
    protected double cost;
    protected double impression_share;

    public CampaignStats() {
	super();
    }

    public CampaignStats(LocalDate date, int impressions, int clicks, int conversions, double cost,
	    double impression_share) {
	super();
	this.date = date;
	this.impressions = impressions;
	this.clicks = clicks;
	this.conversions = conversions;
	this.cost = cost;
	this.impression_share = impression_share;
    }

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
	if (clicks < this.impressions)
	    this.clicks = clicks;
	else {
	    throw new Exception("clicks doit etre inferieur aux nombre  d'impressions");
	}
    }

    public int getConversions() {
	return conversions;
    }

    public void setConversions(int conversions) throws Exception {
	if (conversions < this.clicks)
	    this.conversions = conversions;
	else {
	    throw new Exception("conversion doit etre inferieur aux nombres de clicks");
	}
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
