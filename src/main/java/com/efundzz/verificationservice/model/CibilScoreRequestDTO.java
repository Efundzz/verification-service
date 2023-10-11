package com.efundzz.verificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CibilScoreRequestDTO {

    // Generate a DTO for the request
    /*
     {
  "transID":"128406",
  "docType":"330",
  "firstName":"Vijayaraghavan",
  "middleName":"",
  "lastName":"Sundararaman",
  "mobileNumber":"9980869266",
  "emailAddress":"vijaygenius123@gmail.com",
  "dob":"06-10-1992",
  "idType":"1",
  "idNumber":"DFIPS6275F",
  "gender":"Male",
  "addressLine1":"No 3 Vijay Nivas 1st Main",
  "addressLine2":"1st Cross Mathru Layout",
  "city":"Bangalore",
  "state":"29",
  "pinCode":"560065"
}

     */

    private String transID;
    private String docType;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNumber;
    private String emailAddress;
    private String dob;
    private String idType;
    private String idNumber;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pinCode;
}
