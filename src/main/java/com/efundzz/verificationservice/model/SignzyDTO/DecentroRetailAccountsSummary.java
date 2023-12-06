package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroRetailAccountsSummary {
    private String noOfAccounts;
    private String noOfActiveAccounts;
    private String noOfWriteOffs;
    private String totalPastDue;
    private String singleHighestCredit;
    private String singleHighestSanctionAmount;
    private String totalHighCredit;
    private String averageOpenBalance;
    private String singleHighestBalance;
    private String noOfPastDueAccounts;
    private String noOfZeroBalanceAccounts;
    private String recentAccount;
    private String oldestAccount;
    private String totalBalanceAmount;
    private String totalSanctionAmount;
    private String totalCreditLimit;
    private String totalMonthlyPaymentAmount;

    public String getNoOfAccounts() {
        return noOfAccounts;
    }

    public void setNoOfAccounts(String noOfAccounts) {
        this.noOfAccounts = noOfAccounts;
    }

    public String getNoOfActiveAccounts() {
        return noOfActiveAccounts;
    }

    public void setNoOfActiveAccounts(String noOfActiveAccounts) {
        this.noOfActiveAccounts = noOfActiveAccounts;
    }

    public String getNoOfWriteOffs() {
        return noOfWriteOffs;
    }

    public void setNoOfWriteOffs(String noOfWriteOffs) {
        this.noOfWriteOffs = noOfWriteOffs;
    }

    public String getTotalPastDue() {
        return totalPastDue;
    }

    public void setTotalPastDue(String totalPastDue) {
        this.totalPastDue = totalPastDue;
    }

    public String getSingleHighestCredit() {
        return singleHighestCredit;
    }

    public void setSingleHighestCredit(String singleHighestCredit) {
        this.singleHighestCredit = singleHighestCredit;
    }

    public String getSingleHighestSanctionAmount() {
        return singleHighestSanctionAmount;
    }

    public void setSingleHighestSanctionAmount(String singleHighestSanctionAmount) {
        this.singleHighestSanctionAmount = singleHighestSanctionAmount;
    }

    public String getTotalHighCredit() {
        return totalHighCredit;
    }

    public void setTotalHighCredit(String totalHighCredit) {
        this.totalHighCredit = totalHighCredit;
    }

    public String getAverageOpenBalance() {
        return averageOpenBalance;
    }

    public void setAverageOpenBalance(String averageOpenBalance) {
        this.averageOpenBalance = averageOpenBalance;
    }

    public String getSingleHighestBalance() {
        return singleHighestBalance;
    }

    public void setSingleHighestBalance(String singleHighestBalance) {
        this.singleHighestBalance = singleHighestBalance;
    }

    public String getNoOfPastDueAccounts() {
        return noOfPastDueAccounts;
    }

    public void setNoOfPastDueAccounts(String noOfPastDueAccounts) {
        this.noOfPastDueAccounts = noOfPastDueAccounts;
    }

    public String getNoOfZeroBalanceAccounts() {
        return noOfZeroBalanceAccounts;
    }

    public void setNoOfZeroBalanceAccounts(String noOfZeroBalanceAccounts) {
        this.noOfZeroBalanceAccounts = noOfZeroBalanceAccounts;
    }

    public String getRecentAccount() {
        return recentAccount;
    }

    public void setRecentAccount(String recentAccount) {
        this.recentAccount = recentAccount;
    }

    public String getOldestAccount() {
        return oldestAccount;
    }

    public void setOldestAccount(String oldestAccount) {
        this.oldestAccount = oldestAccount;
    }

    public String getTotalBalanceAmount() {
        return totalBalanceAmount;
    }

    public void setTotalBalanceAmount(String totalBalanceAmount) {
        this.totalBalanceAmount = totalBalanceAmount;
    }

    public String getTotalSanctionAmount() {
        return totalSanctionAmount;
    }

    public void setTotalSanctionAmount(String totalSanctionAmount) {
        this.totalSanctionAmount = totalSanctionAmount;
    }

    public String getTotalCreditLimit() {
        return totalCreditLimit;
    }

    public void setTotalCreditLimit(String totalCreditLimit) {
        this.totalCreditLimit = totalCreditLimit;
    }

    public String getTotalMonthlyPaymentAmount() {
        return totalMonthlyPaymentAmount;
    }

    public void setTotalMonthlyPaymentAmount(String totalMonthlyPaymentAmount) {
        this.totalMonthlyPaymentAmount = totalMonthlyPaymentAmount;
    }
}
