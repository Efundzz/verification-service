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

    public DecentroIDAndContactInfo getiDAndContactInfo() {
        return iDAndContactInfo;
    }

    public void setiDAndContactInfo(DecentroIDAndContactInfo iDAndContactInfo) {
        this.iDAndContactInfo = iDAndContactInfo;
    }

    public DecentroRetailAccountsSummary getRetailAccountsSummary() {
        return retailAccountsSummary;
    }

    public void setRetailAccountsSummary(DecentroRetailAccountsSummary retailAccountsSummary) {
        this.retailAccountsSummary = retailAccountsSummary;
    }

    public List<DecentroScoreDetails> getScoreDetails() {
        return scoreDetails;
    }

    public void setScoreDetails(List<DecentroScoreDetails> scoreDetails) {
        this.scoreDetails = scoreDetails;
    }

    public DecentroOtherKeyInd getOtherKeyInd() {
        return otherKeyInd;
    }

    public void setOtherKeyInd(DecentroOtherKeyInd otherKeyInd) {
        this.otherKeyInd = otherKeyInd;
    }

    public DecentroRecentActivities getRecentActivities() {
        return recentActivities;
    }

    public void setRecentActivities(DecentroRecentActivities recentActivities) {
        this.recentActivities = recentActivities;
    }
}
