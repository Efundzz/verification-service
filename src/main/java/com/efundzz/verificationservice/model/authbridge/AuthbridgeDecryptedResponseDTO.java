package com.efundzz.verificationservice.model.authbridge;

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
public class AuthbridgeDecryptedResponseDTO<T> {

    private Integer status;
    private T msg;
    private String tsTransID;
}
