package com.efundzz.verificationservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthbridgeDocType {
    PAN(2),
    ADVANCED_PAN(470),
    AADHAAR_OCR(1),
    AADHAAR(347),
    CREDIT_SCORE(45),
    GSTIN(23),
    CIN(15);

    private Integer value;
}
