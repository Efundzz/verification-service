package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINDetailed {
    private String constitutionOfBusiness;
    private String legalNameOfBusiness;
    private String tradeNameOfBusiness;
    private String centreJurisdiction;
    private String stateJurisdiction;
    private String registrationDate;
    private String taxPayerDate;
    private String taxPayerType;
    private String gstinStatus;
    private String cancellationDate;
    private List<String> natureOfBusinessActivities;
    private String principalPlaceLatitude;
    private String principalPlaceLongitude;
    private String principalPlaceStreet;
    private String principalPlaceLocality;
    private String principalPlaceCity;
    private String principalPlaceDistrict;
    private String principalPlaceState;
    private String principalPlacePincode;
    private String additionalPlaceLatitude;
    private String additionalPlaceLongitude;
    private String additionalPlaceStreet;
    private String additionalPlaceLocality;
    private String additionalPlaceCity;
    private String additionalPlaceDistrict;
    private String additionalPlaceState;
    private String additionalPlacePincode;
    private String complianceRating;
    private List<String> additionalPlaceAddress;
    private List<String> directorNames;
    private GSTINPrincipalPlaceAddress principalPlaceAddress;
}
