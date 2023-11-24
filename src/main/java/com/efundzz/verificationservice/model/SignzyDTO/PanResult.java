package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanResult {
    private String name;
    private String number;
    private String typeOfHolder;
    private boolean isIndividual;
    private boolean isValid;
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;
    private String panStatus;
    private String panStatusCode;
    private String aadhaarSeedingStatus;
    private String aadhaarSeedingStatusCode;
    private String lastUpdatedOn;
    private long updatetTimestamp;
}
