package com.am.konversion.domain.campaign;

import java.util.HashSet;
import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import com.am.konversion.domain.campaign_stats.CampaignStats;
import com.am.konversion.domain.enum_konversion.Language;

public abstract class Campaign {

	@Id
	protected String _id;
	protected String name;
	protected Language language;
	protected double bid;
	protected double budget;

	@Embedded
	protected Set<CampaignStats> stats;

	public Campaign(String _id, String name, Language language, double bid, double budget) {
		super();
		this._id = _id;
		this.name = name;
		this.language = language;
		this.bid = bid;
		this.budget = budget;
		this.stats = new HashSet<CampaignStats>();
	}

	public Campaign() {
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Set<CampaignStats> getStats() {
		return stats;
	}

	public void setStats(Set<CampaignStats> stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "Campaign [_id=" + _id + ", name=" + name + ", language=" + language + ", bid=" + bid + ", budget="
				+ budget + ", stats=" + stats + "]";
	}

}
