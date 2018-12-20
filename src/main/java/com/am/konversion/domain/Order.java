package com.am.konversion.domain;

import java.util.Date;

import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

public class Order {

    @Indexed(options = @IndexOptions(unique=true))
    private String name;
    private Date start_Date;
    private Date end_date;
    private double budget;

    public Order(String name, Date start_Date, Date end_date, double budget) {
	super();
	this.name = name;
	this.start_Date = start_Date;
	this.end_date = end_date;
	this.budget = budget;
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
	if (bugdet > 0.0)
	    this.budget = bugdet;
	else {
	    throw new Exception();
	}
    }

    @Override
    public String toString() {
	return "Order [name=" + name + ", start_Date=" + start_Date + ", end_date=" + end_date + ", budget=" + budget
		+ "]";
    }

}
