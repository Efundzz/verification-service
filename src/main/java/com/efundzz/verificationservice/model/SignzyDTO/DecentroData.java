package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroData {
    private DecentroCCRResponse cCRResponse;

    public DecentroCCRResponse getcCRResponse() {
        return cCRResponse;
    }

    public void setcCRResponse(DecentroCCRResponse cCRResponse) {
        this.cCRResponse = cCRResponse;
    }
}