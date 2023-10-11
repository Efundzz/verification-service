package com.efundzz.verificationservice.model.pan;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvancedPANRequestDTO {
    private String transID;
    private String docType;
    private String panNumber;
}
