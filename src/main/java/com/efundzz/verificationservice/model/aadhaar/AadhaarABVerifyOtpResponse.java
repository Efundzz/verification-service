package com.efundzz.verificationservice.model.aadhaar;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class AadhaarABVerifyOtpResponse {
    @JsonAlias("Name")
    private String name;

    @JsonAlias("DOB")
    private String dob;

    @JsonAlias("Gender")
    private String gender;

    @JsonAlias("House Number")
    private String houseNumber;

    @JsonAlias("Street")
    private String street;

    @JsonAlias("Locality")
    private String locality;

    @JsonAlias("Landmark")
    private String landmark;

    @JsonAlias("Post Office")
    private String postOffice;

    @JsonAlias("Village/Town/City")
    private String town;

    @JsonAlias("State")
    private String state;

    @JsonAlias("District")
    private String district;

    @JsonAlias("Sub District")
    private String subDistrict;

    @JsonAlias("Country")
    private String country;

    @JsonAlias("Pincode")
    private String pincode;

    @JsonAlias("Image")
    private String image;

    @JsonAlias("Father Name")
    private String fatherName;

    @JsonAlias("Document link")
    private String documentLink;

    @JsonAlias("shareCode")
    private String shareCode;

}
