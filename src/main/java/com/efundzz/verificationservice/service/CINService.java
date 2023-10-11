package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.cin.CinABResponse;
import com.efundzz.verificationservice.model.enums.AuthbridgeDocType;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.CommonVariables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CINService {

    private AuthBridgeService authBridgeService;
    private AuthBridgeClient authBridgeClient;

    public CINService(AuthBridgeService authBridgeService, AuthBridgeClient authBridgeClient) {
        this.authBridgeService = authBridgeService;
        this.authBridgeClient = authBridgeClient;
    }

    public GenericApiResponse<CinABResponse> fetchCINResponse(IDSearchRequestDTO cinRequest) {
        cinRequest.setDocType(AuthbridgeDocType.CIN.getValue().toString());

        AuthBridgeFunction abFunction = () -> authBridgeClient.idSearch(AesCbcCrypto.getEncryptedRequest(cinRequest));
        AuthbridgeDecryptedResponseDTO<CinABResponse> response = authBridgeService.callAuthBridge(cinRequest.getTransID(), KycStepName.CIN, cinRequest, abFunction, CinABResponse.class);

        return GenericApiResponse.<CinABResponse>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e == 1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                .data(response.getMsg()).build();
    }
}
