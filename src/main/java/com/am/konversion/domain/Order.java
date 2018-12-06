package com.am.konversion.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import com.am.konversion.domain.campaign.Campaign;

public class Order {

	private String name;
	private LocalDate start_Date;
	private LocalDate end_date;
	private double budget;

	private Set<Campaign> campaigns;

	public Order(String name, LocalDate start_Date, LocalDate end_date, double budget, Set<Campaign> campaigns) {
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

	public LocalDate getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(LocalDate start_Date) {
		this.start_Date = start_Date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
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
