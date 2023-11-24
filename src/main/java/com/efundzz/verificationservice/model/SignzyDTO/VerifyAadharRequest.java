package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyAadharRequest {
    private  String service;
    private String itemId;
    private String accessToken;
    private String task;
    private Essentials essentials;

}
