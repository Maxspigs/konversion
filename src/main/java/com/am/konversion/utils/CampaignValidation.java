package com.am.konversion.utils;

import com.am.konversion.domain.account.Account;
import com.am.konversion.domain.account.AdwordsAccount;
import com.am.konversion.domain.account.BingAccount;
import com.am.konversion.domain.campaign.AdwordsCampaign;
import com.am.konversion.domain.campaign.BingCampaign;
import com.am.konversion.domain.campaign.Campaign;

public class CampaignValidation {
    
    public static boolean isSamePlatform(Account account, Campaign campaign) {
	return (account instanceof AdwordsAccount && campaign instanceof AdwordsCampaign)
		|| (account instanceof BingAccount && campaign instanceof BingCampaign);
    }

}
