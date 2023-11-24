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
}
