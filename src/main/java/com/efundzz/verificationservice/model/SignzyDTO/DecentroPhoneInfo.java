package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroPhoneInfo {
    private String seq;
    private String typeCode;
    private String reportedDate;
    private String number;
}
