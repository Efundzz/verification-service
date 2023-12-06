package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroCIRReportDataLst {
    private DecentroCIRReportData cIRReportData;

    public DecentroCIRReportData getcIRReportData() {
        return cIRReportData;
    }

    public void setcIRReportData(DecentroCIRReportData cIRReportData) {
        this.cIRReportData = cIRReportData;
    }
}
