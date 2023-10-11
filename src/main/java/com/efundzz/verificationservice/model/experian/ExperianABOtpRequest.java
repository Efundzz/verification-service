package com.efundzz.verificationservice.model.experian;

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
public class ExperianABOtpRequest {
    private String transID;
    private Integer docType;
    private String email;
    private String candidateName;
    private String organisationName;
    private String authToken;
    private String mobileNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    /* need to implement date formatter for dob */
    private String dob;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String pan;
    private String passportNumber;
    private String voterId;


}
