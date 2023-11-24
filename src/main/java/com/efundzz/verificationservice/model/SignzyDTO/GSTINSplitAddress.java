package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINSplitAddress {
    private List<String> district;
    private List<List<String>> state;
    private List<String> city;
    private String pincode;
    private List<String> country;
    private String addressLine;
}
