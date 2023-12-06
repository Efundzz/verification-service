package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroAddressInfo {
    private String seq;
    private String reportedDate;
    private String address;
    private String state;
    private String postal;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
