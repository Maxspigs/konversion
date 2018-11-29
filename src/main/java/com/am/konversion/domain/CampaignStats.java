package com.am.konversion.domain;

import java.sql.Date;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class CampaignStats {
    
    protected Campaign campaign_id;
    protected Date date;
    protected int impressions;
    protected int click;
    protected int conversion;
    protected double cost;
    protected double impression_share;

}
