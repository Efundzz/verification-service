package com.efundzz.verificationservice.controller;

import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABOCRRequest;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABVerifyOtpResponse;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeVerifyOtpRequest;
import com.efundzz.verificationservice.service.AadhaarVerificationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kyc/aadhaar")
public class AadhaarVerificationController {

    private AadhaarVerificationService aadhaarVerificationService;

    public AadhaarVerificationController(AadhaarVerificationService aadhaarVerificationService) {
        this.aadhaarVerificationService = aadhaarVerificationService;
    }

    @PostMapping("/test")
    public ResponseEntity<GenericApiResponse<String>> test(@Valid @RequestBody KycRequestDTO kycRequestDTO) {
        return ResponseEntity.ok().body(GenericApiResponse.<String>builder().data("Test completed successfully").build());
    }

    @PostMapping("/generateOTP")
    public ResponseEntity<GenericApiResponse<String>> generateAadharOtp(@RequestBody KycRequestDTO kycRequestDTO) {
        GenericApiResponse<String> response = aadhaarVerificationService.generateAadhaarOtp(kycRequestDTO);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }

    @PostMapping("/verifyOTP")
    public ResponseEntity<GenericApiResponse<AadhaarABVerifyOtpResponse>> verifyAadharOtp(@RequestBody AuthbridgeVerifyOtpRequest aadharOtpRequest) {
        GenericApiResponse<AadhaarABVerifyOtpResponse> response = aadhaarVerificationService.verifyAadhaarOtp(aadharOtpRequest);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }

    @PostMapping("/verifyOCRImage")
    public ResponseEntity<GenericApiResponse<AadhaarABVerifyOtpResponse>> verifyAadharOcrImage(@RequestBody AadhaarABOCRRequest aadharABOCRRequest) {
        GenericApiResponse<AadhaarABVerifyOtpResponse> response = aadhaarVerificationService.verifyAadhaarOcrImage(aadharABOCRRequest);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }
}
