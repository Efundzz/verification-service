package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroResponse {
    private String decentroTxnId;
    private String status;
    private String responseCode;
    private String message;
    private DecentroData data;
    private String responseKey;

    public String getDecentroTxnId() {
        return decentroTxnId;
    }

    public void setDecentroTxnId(String decentroTxnId) {
        this.decentroTxnId = decentroTxnId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DecentroData getData() {
        return data;
    }

    public void setData(DecentroData data) {
        this.data = data;
    }

    public String getResponseKey() {
        return responseKey;
    }

    public void setResponseKey(String responseKey) {
        this.responseKey = responseKey;
    }
}
