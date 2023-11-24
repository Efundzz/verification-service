package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroAddressInfo {
    private String seq;
    private String reportedDate;
    private String address;
    private String state;
    private String postal;
}
