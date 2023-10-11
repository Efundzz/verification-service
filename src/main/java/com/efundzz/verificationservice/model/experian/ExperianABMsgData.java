package com.efundzz.verificationservice.model.experian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperianABMsgData {
    private ExperianABApplicationInfo application_information;
    private ExperianABPersona persona;
    private String report_file;
    private Object insights_credit;
}
