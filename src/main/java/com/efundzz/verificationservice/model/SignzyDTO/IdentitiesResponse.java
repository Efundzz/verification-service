package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentitiesResponse {
    private String type;
    private String email;
    private String callbackUrl;
    private String[] images;
    private String accessToken;
    private String[] autoRecognition;
    private String[] verification;
    private String[] forgeryCheck;
    private String id;
    private String patronId;
}
