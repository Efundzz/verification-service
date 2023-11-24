package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyAadharResult {
    private String verified;
    private String ageBand;
    private String state;
    private String mobileNumber;
    private String gender;
}
