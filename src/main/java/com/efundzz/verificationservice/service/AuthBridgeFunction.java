package com.efundzz.verificationservice.service;


import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;

@FunctionalInterface
public interface AuthBridgeFunction {
    AuthbridgeEncryptedResponseDTO call();

}
