package com.efundzz.verificationservice.model.aadhaar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AadhaarABOtpRequest {
    private String transID;
    private Integer docType;
    private String docNumber;
    private String secretToken;
    private String tsTransID;
    private String captchaCode;
    private String actionType;
    private Integer consent;
}
