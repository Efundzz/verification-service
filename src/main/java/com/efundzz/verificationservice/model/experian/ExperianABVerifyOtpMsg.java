package com.efundzz.verificationservice.model.experian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperianABVerifyOtpMsg {
    private String msg;
//    private String xml_file;
    private ExperianABMsgData data;
}
