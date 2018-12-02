package com.am.konversion.domain;

import java.util.Date;
import java.util.Set;

import com.am.konversion.domain.campaign.Campaign;

public class Order {

	private String name;
	private Date start_Date;
	private Date end_date;
	private double budget;

	private Set<Campaign> campaigns;

	public Order(String name, Date start_Date, Date end_date, double budget, Set<Campaign> campaigns) {
		super();
		this.name = name;
		this.start_Date = start_Date;
		this.end_date = end_date;
		this.budget = budget;
		this.campaigns = campaigns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double bugdet) throws Exception {
		if(bugdet > 0.0)
			this.budget = bugdet;
		else {
			throw new Exception();
		}
	}

	public Set<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Set<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	@Override
	public String toString() {
		return "Order [name=" + name + ", start_Date=" + start_Date + ", end_date=" + end_date + ", budget=" + budget
				+ ", campaigns=" + campaigns + "]";
	}

}
