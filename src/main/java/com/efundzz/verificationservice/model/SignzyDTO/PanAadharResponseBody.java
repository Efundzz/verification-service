package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanAadharResponseBody {
    private String service;
    private String itemId;
    private String task;
    private Essentials essentials;
    private String accessToken;
    private String id;
    private PanAadharResponse response;
}
