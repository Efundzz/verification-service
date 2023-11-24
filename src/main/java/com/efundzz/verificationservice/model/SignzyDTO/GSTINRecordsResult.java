package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINRecordsResult {
    private String applicationStatus;
    private String registrationName;
    private String mobNum;
    private String regType;
    private String emailId;
    private String tinNumber;
    private String gstinRefId;
    private String gstin;
}
