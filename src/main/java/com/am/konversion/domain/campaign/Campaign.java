package com.am.konversion.domain.campaign;

import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import com.am.konversion.domain.campaign_stats.CampaignStats;
import com.am.konversion.domain.enum_konversion.Language;

@Embedded
public class Campaign {

	@Id
	protected String _id;
	protected String name;
	protected Language language;
	protected double bid;
	protected double budget;

	protected Set<CampaignStats> stats;
}
