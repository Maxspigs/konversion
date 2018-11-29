package com.am.konversion.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("campaign")
public class Campaign {

    @Reference(lazy=true)
    protected Account account_id;
    
    @Id protected String id;
    protected String name;
    protected Language language;
    protected double bid;
    protected double budget;
    
}
