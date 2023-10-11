package com.efundzz.verificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquifaxScoreRequestDTO {

    // Generate a DTO for the request
    /*
     {
                                    "transID": "1234567",
                                    "docType": 515,
                                    "first_name":"Sunil",
                                    "last_name":"",
                                    "transaction_amount":0,
                                    "address":"Delhi",
                                    "dob":"2022-03-01",
                                    "inquery_type":"00",
                                     "marital_status":"Single",
                                    "gender":"1",
                                    "state":"TN",
                                    "id_type":"PANId",
                                    "id_number":"CMNPS9561A",
                                    "pincode":"301401",
                                    "mobile_number":"9990723442"
                                }

     */

    private String transID;
    private String docType;
    private String first_name;
    private String last_name;
    private String transaction_amount;
    private String address;
    private String dob;
    private String inquery_type;
    private String marital_status;
    private String gender;
    private String state;
    private String id_type;
    private String id_number;
    private String pincode;
    private String mobile_number;
}
