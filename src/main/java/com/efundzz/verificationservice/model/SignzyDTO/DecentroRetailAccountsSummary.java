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
}
