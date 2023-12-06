package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroRecentActivities {
    private String accountsDelinquent;
    private String accountsOpened;
    private String totalInquiries;
    private String accountsUpdated;

    public String getAccountsDelinquent() {
        return accountsDelinquent;
    }

    public void setAccountsDelinquent(String accountsDelinquent) {
        this.accountsDelinquent = accountsDelinquent;
    }

    public String getAccountsOpened() {
        return accountsOpened;
    }

    public void setAccountsOpened(String accountsOpened) {
        this.accountsOpened = accountsOpened;
    }

    public String getTotalInquiries() {
        return totalInquiries;
    }

    public void setTotalInquiries(String totalInquiries) {
        this.totalInquiries = totalInquiries;
    }

    public String getAccountsUpdated() {
        return accountsUpdated;
    }

    public void setAccountsUpdated(String accountsUpdated) {
        this.accountsUpdated = accountsUpdated;
    }
}
