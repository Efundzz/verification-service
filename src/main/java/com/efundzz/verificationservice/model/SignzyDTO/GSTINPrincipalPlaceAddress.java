package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINPrincipalPlaceAddress {
    public String emailId;
    public String address;
    public String natureOfBusiness;
    public String mobile;
    public String lastUpdatedDate;
    public GSTINSplitAddress splitAddress;
}
