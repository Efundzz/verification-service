package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeVerifyOtpRequest;
import com.efundzz.verificationservice.model.experian.ExperianVerifyOtpResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreVerificationService {

    private ExperianService experianService;

    public CreditScoreVerificationService(ExperianService experianService) {
        this.experianService = experianService;
    }

    public GenericApiResponse<String> generateOtpForCreditScore(KycRequestDTO kycRequestDTO) {
        return experianService.generateOtpForCreditScore(kycRequestDTO);
    }

    public GenericApiResponse<ExperianVerifyOtpResponse> verifyOtpForCreditScore(AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        return experianService.verifyOtpForCreditScore(verifyOtpRequest);
    }

    public GenericApiResponse<String> skipCreditScoreCheck(AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        return experianService.skipCreditScoreCheck(verifyOtpRequest);
    }
}
