package com.efundzz.verificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycRequestDTO {

    @NotBlank(message = "transID cannot be null")
    private String transID;
    private String docType;
    @NotBlank(message = "docNumber cannot be null")
    private String docNumber;
}
