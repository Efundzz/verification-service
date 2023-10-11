package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.enums.AuthbridgeDocType;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.model.gst.GstABResponse;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.CommonVariables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Slf4j
@Service
public class GSTService {

    private AuthBridgeService authBridgeService;
    private AuthBridgeClient authBridgeClient;

    public GSTService(AuthBridgeService authBridgeService, AuthBridgeClient authBridgeClient) {
        this.authBridgeService = authBridgeService;
        this.authBridgeClient = authBridgeClient;
    }

    public GenericApiResponse<GstABResponse> fetchGstResponse(IDSearchRequestDTO gstRequest) {
        gstRequest.setDocType(AuthbridgeDocType.GSTIN.getValue().toString());

        AuthBridgeFunction abFunction = () -> authBridgeClient.idSearch(AesCbcCrypto.getEncryptedRequest(gstRequest));
        AuthbridgeDecryptedResponseDTO<GstABResponse> response = authBridgeService.callAuthBridge(gstRequest.getTransID(), KycStepName.GSTIN, gstRequest, abFunction, GstABResponse.class);

        return GenericApiResponse.<GstABResponse>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e == 1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                .data(response.getMsg()).build();
    }
}
