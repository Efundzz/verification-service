package com.efundzz.verificationservice.service;

import com.efundzz.dbconnect.entity.KycModel;
import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABCapchaRequest;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABImage;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABOCRRequest;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABOCRResponse;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABOtpRequest;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABVerifyOtpRequest;
import com.efundzz.verificationservice.model.aadhaar.AadhaarABVerifyOtpResponse;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeVerifyOtpRequest;
import com.efundzz.verificationservice.model.enums.AuthbridgeDocType;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.CommonVariables;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class AadhaarVerificationService {

    private final AuthBridgeService authBridgeService;
    private final AuthBridgeClient authBridgeClient;
    private final PersistenceService persistenceService;

    public AadhaarVerificationService(AuthBridgeService authBridgeService, AuthBridgeClient authBridgeClient, PersistenceService persistenceService) {
        this.authBridgeService = authBridgeService;
        this.authBridgeClient = authBridgeClient;
        this.persistenceService = persistenceService;
    }

    public GenericApiResponse<String> generateAadhaarOtp(KycRequestDTO AadhaarOtpRequest) {
        AuthbridgeDecryptedResponseDTO<AadhaarABImage> image = getAadhaarImage(AadhaarOtpRequest.getTransID());
        if(Objects.nonNull(image)) {
            AtomicReference<AadhaarABOtpRequest> requestDTO = new AtomicReference<>(new AadhaarABOtpRequest());

            Optional.ofNullable(image.getMsg()).ifPresent(msg -> {
                requestDTO.set(AadhaarABOtpRequest.builder()
                        .transID(AadhaarOtpRequest.getTransID())
                        .docType(AuthbridgeDocType.AADHAAR.getValue())
                        .docNumber(AadhaarOtpRequest.getDocNumber())
                        .secretToken(msg.getSecretToken())
                        .tsTransID(msg.getTsTransID())
                        .captchaCode(CommonVariables.AUTH_BRIDGE_AADHAAR_CAPCHA)
                        .actionType(CommonVariables.OTP)
                        .consent(CommonVariables._1)
                        .build());
            });
            AuthBridgeFunction abFunction = () -> authBridgeClient.aadhaarIdSearch(AesCbcCrypto.getEncryptedRequest(requestDTO.get()));
            AuthbridgeDecryptedResponseDTO<String> response = authBridgeService.callAuthBridge(AadhaarOtpRequest.getTransID(), KycStepName.AADHAAR_OTP_GENERATE, requestDTO, abFunction, String.class);
            return GenericApiResponse.<String>builder()
                    .message((Optional.ofNullable(response.getStatus()).map(e -> e == 1).orElse(false))
                            ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                    .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                    .data(response.getMsg()).build();
        }
        else return GenericApiResponse.<String>builder().message(CommonVariables.FAILURE_MSG).status(0).data(null).build();
    }

    private AuthbridgeDecryptedResponseDTO<AadhaarABImage> getAadhaarImage(String transId) throws RuntimeException {
        AadhaarABCapchaRequest aadhaarABCapchaRequest = AadhaarABCapchaRequest.builder()
                .transID(transId)
                .docType(AuthbridgeDocType.AADHAAR.getValue()).build();

        AuthBridgeFunction abFunction = () -> authBridgeClient.aadhaarImage(AesCbcCrypto.getEncryptedRequest(aadhaarABCapchaRequest));
        return authBridgeService.callAuthBridge(transId, KycStepName.AADHAAR_IMAGE, aadhaarABCapchaRequest, abFunction, AadhaarABImage.class);
    }

    public GenericApiResponse<AadhaarABVerifyOtpResponse> verifyAadhaarOtp(AuthbridgeVerifyOtpRequest AadhaarOtpRequest) {

        String tsTransID = Optional.ofNullable(persistenceService.findFirstByTransIDAndKycStepNameOrderByIdDesc(AadhaarOtpRequest.getTransID(), KycStepName.AADHAAR_OTP_VERIFY))
                .map(KycModel::getAuthBridgeTransID).orElse(StringUtils.EMPTY);

        AadhaarABVerifyOtpRequest requestDTO = AadhaarABVerifyOtpRequest.builder()
                .transID(tsTransID)
                .shareCode(CommonVariables.AUTH_BRIDGE_SHARE_CODE)
                .mobileCode(AadhaarOtpRequest.getOtp())
                .build();

        AuthBridgeFunction abFunction = () -> authBridgeClient.aadhaarVerifyOtp(AesCbcCrypto.getEncryptedRequest(requestDTO));
        AuthbridgeDecryptedResponseDTO<AadhaarABVerifyOtpResponse> response = authBridgeService.callAuthBridge(AadhaarOtpRequest.getTransID(), KycStepName.AADHAAR_OTP_VERIFY, requestDTO, abFunction, AadhaarABVerifyOtpResponse.class);
        return GenericApiResponse.<AadhaarABVerifyOtpResponse>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e==1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                .data(response.getMsg()).build();
    }

    public GenericApiResponse<AadhaarABVerifyOtpResponse> verifyAadhaarOcrImage(AadhaarABOCRRequest request) {
        request.setDocType(AuthbridgeDocType.AADHAAR_OCR.getValue());
        AuthBridgeFunction abFunction = () -> authBridgeClient.sendOcrRequest(AesCbcCrypto.getEncryptedRequest(request));
        AuthbridgeDecryptedResponseDTO<AadhaarABOCRResponse> response = authBridgeService.callAuthBridge(request.getTransID(), KycStepName.AADHAAR_OCR_VERIFY, request, abFunction, AadhaarABOCRResponse.class);
        return mapOcrResponse(response);
    }

    public GenericApiResponse<AadhaarABVerifyOtpResponse> mapOcrResponse(AuthbridgeDecryptedResponseDTO<AadhaarABOCRResponse> AadhaarABOCRResponse) {
        return GenericApiResponse.<AadhaarABVerifyOtpResponse>builder()
                .message((Optional.ofNullable(AadhaarABOCRResponse.getStatus()).map(e -> e==1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(AadhaarABOCRResponse.getStatus()) ? AadhaarABOCRResponse.getStatus() : 0)
                .data((Objects.isNull(AadhaarABOCRResponse.getMsg())) ? null : AadhaarABVerifyOtpResponse.builder()
                        .name(AadhaarABOCRResponse.getMsg().getName())
                        .dob(AadhaarABOCRResponse.getMsg().getDob())
                        .gender(AadhaarABOCRResponse.getMsg().getGender())
                        .houseNumber("")
                        .street(AadhaarABOCRResponse.getMsg().getStreet_address())
                        .locality(AadhaarABOCRResponse.getMsg().getAddress())
                        .landmark("")
                        .postOffice("")
                        .town("")
                        .state(AadhaarABOCRResponse.getMsg().getState())
                        .district(AadhaarABOCRResponse.getMsg().getDistrict())
                        .subDistrict("")
                        .country("")
                        .pincode(AadhaarABOCRResponse.getMsg().getPincode())
                        .image("")
                        .fatherName(AadhaarABOCRResponse.getMsg().getFather_name())
                        .documentLink("")
                        .shareCode("")
                        .build()).build();
    }
}
