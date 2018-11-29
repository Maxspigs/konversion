package com.am.konversion.domain;

import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("account")
public abstract class Account {
    
    @Id protected String id;
    protected String name;
    protected Country country;
    protected Currency currency;
    
    protected Set<Campaign> compaigns;

}
