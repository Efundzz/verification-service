package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINResult {
    public GSTINDetailed gstnDetailed;
    public List<GSTINRecordsResult> gstnRecords;
    public String gstin;
    public String annualAggregateTurnOver;
    public GSTINAggregateTurnOverRange aggregateTurnOverRange;
    public String grossTotalIncome;
    public String grossTotalIncomeFinancialYear;
    public List<GSTINFilingStatus> filingStatus;
}
