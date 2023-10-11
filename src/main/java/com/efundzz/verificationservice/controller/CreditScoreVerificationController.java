package com.efundzz.verificationservice.controller;

import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeVerifyOtpRequest;
import com.efundzz.verificationservice.model.experian.ExperianVerifyOtpResponse;
import com.efundzz.verificationservice.service.CreditScoreVerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kyc/creditscore")
public class CreditScoreVerificationController {

    private CreditScoreVerificationService creditScoreVerificationService;

    public CreditScoreVerificationController(CreditScoreVerificationService creditScoreVerificationService) {
        this.creditScoreVerificationService = creditScoreVerificationService;
    }

    @PostMapping("/generateOTP")
    public ResponseEntity<GenericApiResponse<String>> generateOtpForCreditScore(@RequestBody KycRequestDTO kycRequestDTO) {
        GenericApiResponse<String> response = creditScoreVerificationService.generateOtpForCreditScore(kycRequestDTO);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }

    @PostMapping("/verifyOTP")
    public ResponseEntity<GenericApiResponse<ExperianVerifyOtpResponse>> verifyOtpForCreditScore(@RequestBody AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        GenericApiResponse<ExperianVerifyOtpResponse> response = creditScoreVerificationService.verifyOtpForCreditScore(verifyOtpRequest);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }

    @PostMapping("/skip")
    public ResponseEntity<GenericApiResponse<String>> getNextSteps(@RequestBody AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        return ResponseEntity.ok(creditScoreVerificationService.skipCreditScoreCheck(verifyOtpRequest));
    }
}
