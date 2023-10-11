package com.efundzz.verificationservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KycStepName {
    PAN("pan_details"),
    ADVANCED_PAN("advanced_pan_details"),
    AADHAAR_IMAGE("aadhar_image"),
    AADHAAR_OTP_GENERATE("aadhar_otp_generate"),
    AADHAAR_OTP_VERIFY("aadhar_otp_verify"),
    AADHAAR_OCR_VERIFY("aadhar_ocr_verify"),
    CREDIT_SCORE_OTP_GENERATE("credit_score_otp_generate"),
    CREDIT_SCORE_OTP_VERIFY("credit_score_otp_verify"),
    GSTIN("gstin_details"),

    CIN("cin_details");

    private String value;
}
