package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroCIRReportData {
    private DecentroIDAndContactInfo iDAndContactInfo;
    private DecentroRetailAccountsSummary retailAccountsSummary;
    private List<DecentroScoreDetails> scoreDetails;
    private DecentroOtherKeyInd otherKeyInd;
    private DecentroRecentActivities recentActivities;
}
