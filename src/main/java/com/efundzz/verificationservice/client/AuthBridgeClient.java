package com.efundzz.verificationservice.client;

import com.efundzz.verificationservice.config.FeignConfig;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authBridge", url = "https://www.truthscreen.com", configuration = FeignConfig.class)
public interface AuthBridgeClient {
    @PostMapping("/api/v2.2/idsearch")
    AuthbridgeEncryptedResponseDTO idSearch(@RequestBody AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);
    @PostMapping("/PanVerification/request")
    AuthbridgeEncryptedResponseDTO verifyAdvancedPan(@RequestBody AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/EquifaxScoreApi/request")
    AuthbridgeEncryptedResponseDTO eqifaxScore(@RequestBody AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/api/TucibilApi/fulFillOfferRequest")
    AuthbridgeEncryptedResponseDTO cibilScore(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/Aadhaar/image")
    AuthbridgeEncryptedResponseDTO aadhaarImage(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/Aadhaar/idsearch")
    AuthbridgeEncryptedResponseDTO aadhaarIdSearch(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/Aadhaar/request")
    AuthbridgeEncryptedResponseDTO aadhaarVerifyOtp(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/api/v2.2/ocr")
    AuthbridgeEncryptedResponseDTO sendOcrRequest(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/CreditReportVerificationApi/requestSend")
    AuthbridgeEncryptedResponseDTO generateOtpForCreditScore(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

    @PostMapping("/CreditReportVerificationApi/verifyOtp")
    AuthbridgeEncryptedResponseDTO verifyOtpForCreditScore(AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);

}
