package com.efundzz.verificationservice.service;

import com.efundzz.dbconnect.entity.KycModel;
import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeVerifyOtpRequest;
import com.efundzz.verificationservice.model.enums.AuthbridgeDocType;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.model.experian.ExperianABMsgData;
import com.efundzz.verificationservice.model.experian.ExperianABOtpMsg;
import com.efundzz.verificationservice.model.experian.ExperianABOtpRequest;
import com.efundzz.verificationservice.model.experian.ExperianABPersona;
import com.efundzz.verificationservice.model.experian.ExperianABVerifyOtpMsg;
import com.efundzz.verificationservice.model.experian.ExperianABVerifyOtpRequest;
import com.efundzz.verificationservice.model.experian.ExperianVerifyOtpResponse;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.CommonVariables;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class ExperianService {
    private AuthBridgeService authBridgeService;
    private AuthBridgeClient authBridgeClient;
    private PersistenceService persistenceService;

    public ExperianService(AuthBridgeService authBridgeService, AuthBridgeClient authBridgeClient, PersistenceService persistenceService) {
        this.authBridgeService = authBridgeService;
        this.authBridgeClient = authBridgeClient;
        this.persistenceService = persistenceService;
    }

    ObjectMapper mapper = new ObjectMapper();

    public GenericApiResponse<String> generateOtpForCreditScore(KycRequestDTO kycRequestDTO) {
            AtomicReference<HashMap<String, Object>> stepDetails = new AtomicReference<>();
            stepDetails.set(new HashMap<>());
            persistenceService.getStepsByStepName(kycRequestDTO.getTransID(), Arrays.asList("LoanDetails", "BasicAADHARVerification"))
                    .forEach(stepData -> {
                        HashMap<String, Object> obj = stepDetails.get();
                        obj.putAll(stepData.getData());
                        stepDetails.set(obj);
                    });

            Map<String, Object> address = mapper.convertValue(stepDetails.get().get("currentAddress"), Map.class);

            /* Fetch these info from Loan table once imlpemented */
            ExperianABOtpRequest requestDTO = ExperianABOtpRequest.builder()
                    .transID(kycRequestDTO.getTransID())
                    .docType(AuthbridgeDocType.CREDIT_SCORE.getValue())
                    .email(stepDetails.get().get("email").toString())
                    .candidateName("")
                    .organisationName("")
                    .authToken("")
                    .mobileNumber(stepDetails.get().get("mobile").toString())
                    .firstName(stepDetails.get().get("firstName").toString())
                    .middleName(stepDetails.get().get("middleName").toString())
                    .lastName(stepDetails.get().get("lastName").toString())
                    .dob(stepDetails.get().get("dob").toString())
                    .gender(stepDetails.get().get("gender").toString())
                    .address(address.get("addressLine").toString())
                    .city(address.get("city").toString())
                    .state(address.get("state").toString())
                    .pinCode(address.get("pincode").toString())
                    .pan(stepDetails.get().get("pan").toString())
                    .passportNumber("")
                    .voterId("").build();

        AuthBridgeFunction abFunction = () -> authBridgeClient.generateOtpForCreditScore(AesCbcCrypto.getEncryptedRequest(requestDTO));
        AuthbridgeDecryptedResponseDTO<ExperianABOtpMsg> response = authBridgeService.callAuthBridge(requestDTO.getTransID(), KycStepName.CREDIT_SCORE_OTP_GENERATE, requestDTO, abFunction, ExperianABOtpMsg.class);
        persistenceService.updateTsTransIdToKycDetails(requestDTO.getTransID(), KycStepName.CREDIT_SCORE_OTP_GENERATE, Optional.ofNullable(response.getMsg()).orElse(new ExperianABOtpMsg()).getTsTransID());
        return GenericApiResponse.<String>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e==1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0).build();
    }

    public GenericApiResponse<ExperianVerifyOtpResponse> verifyOtpForCreditScore(AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        String tsTransID = Optional.ofNullable(persistenceService.findFirstByTransIDAndKycStepNameOrderByIdDesc(verifyOtpRequest.getTransID(), KycStepName.CREDIT_SCORE_OTP_GENERATE))
                .map(KycModel::getAuthBridgeTransID).orElse(StringUtils.EMPTY);
        ExperianABVerifyOtpRequest requestDTO = ExperianABVerifyOtpRequest.builder()
                .transID(verifyOtpRequest.getTransID())
                .docType(AuthbridgeDocType.CREDIT_SCORE.getValue())
                .tsTransID(tsTransID)
                .otp(verifyOtpRequest.getOtp())
                .verifyotp("1")
                .resendotp("0").build();

        AuthBridgeFunction abFunction = () -> authBridgeClient.verifyOtpForCreditScore(AesCbcCrypto.getEncryptedRequest(requestDTO));
        AuthbridgeDecryptedResponseDTO<ExperianABVerifyOtpMsg> response = authBridgeService.callAuthBridge(requestDTO.getTransID(), KycStepName.CREDIT_SCORE_OTP_VERIFY, requestDTO, abFunction, ExperianABVerifyOtpMsg.class);
        boolean isResponseStatusSuccess = (Optional.ofNullable(response.getStatus()).map(e -> e==1).orElse(false));
        boolean isEligible = isCreditScoreEligible(verifyOtpRequest.getTransID(), response);

        return GenericApiResponse.<ExperianVerifyOtpResponse>builder()
                .message(isResponseStatusSuccess ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(isResponseStatusSuccess ? 1 : 0)
                .data(isResponseStatusSuccess
                        ? ExperianVerifyOtpResponse.builder().eligibility(isEligible).build() : null).build();
    }

    private void saveCreditScore(String transID, String creditScore) {
        Map<String, Object> creditScoreMap = new HashMap<>();
        creditScoreMap.put("creditScore", creditScore);
        persistenceService.saveStepData(transID, "CreditScore", creditScoreMap);
    }

    private boolean isCreditScoreEligible(String transID, AuthbridgeDecryptedResponseDTO<ExperianABVerifyOtpMsg> response) {
        List<String> elibleCreditScores = Arrays.asList("A+", "A", "B", "C", "D", "E", "NH");

        String creditScore = Optional.ofNullable(response)
                .map(AuthbridgeDecryptedResponseDTO::getMsg)
                .map(ExperianABVerifyOtpMsg::getData)
                .map(ExperianABMsgData::getPersona)
                .map(ExperianABPersona::getCredit_score).orElse("");

        saveCreditScore(transID, creditScore);
        return elibleCreditScores.contains(creditScore);
    }

    public GenericApiResponse<String> skipCreditScoreCheck(AuthbridgeVerifyOtpRequest verifyOtpRequest) {
        saveCreditScore(verifyOtpRequest.getTransID(), "");
        return GenericApiResponse.<String>builder()
                .message(CommonVariables.SUCCESS_MSG)
                .status(1).build();
    }
}
