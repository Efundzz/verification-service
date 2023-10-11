package com.efundzz.verificationservice.model.experian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperianABApplicationInfo {
    private String first_name;
    private String last_name;
    private String mobile_number;
    private String email_address;
    private String id_type;
    private String id_number;
    private String dob;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String report_pull_date;
    private String pincode;
}
