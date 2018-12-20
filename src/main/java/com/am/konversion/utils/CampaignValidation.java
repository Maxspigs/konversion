package com.am.konversion.utils;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.BingCampaign;
import com.am.konversion.domain.campaign.Campaign;
import com.am.konversion.domain.campaign_stats.AdwordsCampaignStats;
import com.am.konversion.domain.campaign_stats.BingCampaignStats;
import com.am.konversion.domain.campaign_stats.CampaignStats;

public class CampaignValidation {
    
    public static boolean isSamePlatform(Account account, Campaign campaign) {
	return (account instanceof AdwordsAccount && campaign instanceof AdwordsCampaign)
		|| (account instanceof BingAccount && campaign instanceof BingCampaign);
    }
    
    public static boolean isSamePlatform(Campaign campaign, CampaignStats stat) {
	return (campaign instanceof AdwordsCampaign && stat instanceof AdwordsCampaignStats)
		|| (campaign instanceof BingCampaign && stat instanceof BingCampaignStats);
    }

}
