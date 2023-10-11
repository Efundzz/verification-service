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
public class AadhaarABOCRResponse {
    private String name;
    private Integer age;
    private String dob;
    private String yob;
    private String gender;
    private String father_name;
    private String minor;
    private String relation_name;
    private String relation_type;
    private String address;
    private String street_address;
    private String district;
    private String pincode;
    private String state;
    private String doc_id;
    private String doi;
    private String is_scanned;
    private String scan_type;
}
