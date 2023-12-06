package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroRequest {
    private String reference_id;
    private boolean consent;
    private String consent_purpose;
    private String name;
    private String mobile;
    private String inquiry_purpose;
}

