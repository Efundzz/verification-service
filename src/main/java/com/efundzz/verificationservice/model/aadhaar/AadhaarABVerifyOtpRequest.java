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
public class AadhaarABVerifyOtpRequest {
    private String transID;
    private String shareCode;
    private String mobileCode;
}
