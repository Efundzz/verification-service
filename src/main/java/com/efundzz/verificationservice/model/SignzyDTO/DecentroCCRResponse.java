package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroCCRResponse {
    private String status;
    private List<DecentroCIRReportDataLst> cIRReportDataLst;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DecentroCIRReportDataLst> getcIRReportDataLst() {
        return cIRReportDataLst;
    }

    public void setcIRReportDataLst(List<DecentroCIRReportDataLst> cIRReportDataLst) {
        this.cIRReportDataLst = cIRReportDataLst;
    }
}
