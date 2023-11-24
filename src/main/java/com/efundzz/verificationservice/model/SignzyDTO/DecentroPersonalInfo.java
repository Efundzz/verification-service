package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroPersonalInfo {
    private DecentroName name;
    private String dateOfBirth;
    private String gender;
    private DecentroAge age;
}
