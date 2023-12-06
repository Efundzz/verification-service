package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroPhoneInfo {
    private String seq;
    private String typeCode;
    private String reportedDate;
    private String number;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
