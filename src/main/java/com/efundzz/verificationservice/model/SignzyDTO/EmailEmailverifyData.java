package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEmailverifyData {
    private String email;
    private String status;
    private String sub_status;
    private boolean free_email;
    private String did_you_mean;
    private String account;
    private String domain;
    private String domain_age_days;
    private String smtp_provider;
    private boolean mx_found;
    private String mx_record;
    private String gender;
    private String country;
    private String region;
    private String city;
    private String zipcode;
    private String firstname;
    private String lastname;
    private String name;
}
