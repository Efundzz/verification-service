package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.enums.AuthbridgeDocType;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.model.pan.AdvancedPANRequestDTO;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.CommonVariables;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PANService {

    private AuthBridgeService authBridgeService;
    private AuthBridgeClient authBridgeClient;

    public PANService(AuthBridgeService authBridgeService, AuthBridgeClient authBridgeClient) {
         this.authBridgeService = authBridgeService;
         this.authBridgeClient = authBridgeClient;
    }

    public GenericApiResponse<AuthbridgeDecryptedResponseDTO> fetchPanDetails(IDSearchRequestDTO panRequestDTO) {
        panRequestDTO.setDocType(AuthbridgeDocType.PAN.getValue().toString());

        AuthBridgeFunction abFunction = () -> authBridgeClient.idSearch(AesCbcCrypto.getEncryptedRequest(panRequestDTO));
        AuthbridgeDecryptedResponseDTO<Object> response = authBridgeService.callAuthBridge(panRequestDTO.getTransID(), KycStepName.PAN, panRequestDTO, abFunction, Object.class);

        return GenericApiResponse.<AuthbridgeDecryptedResponseDTO>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e==1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                .data(response).build();
    }

    public GenericApiResponse<AuthbridgeDecryptedResponseDTO> getAdvancedPanDetails(AdvancedPANRequestDTO panRequestDTO) {
        panRequestDTO.setDocType(AuthbridgeDocType.ADVANCED_PAN.getValue().toString());

        AuthBridgeFunction abFunction = () -> authBridgeClient.verifyAdvancedPan(AesCbcCrypto.getEncryptedRequest(panRequestDTO));
        AuthbridgeDecryptedResponseDTO<Object> response =  authBridgeService.callAuthBridge(panRequestDTO.getTransID(), KycStepName.ADVANCED_PAN, panRequestDTO, abFunction, Object.class);

        return GenericApiResponse.<AuthbridgeDecryptedResponseDTO>builder()
                .message((Optional.ofNullable(response.getStatus()).map(e -> e==1).orElse(false))
                        ? CommonVariables.SUCCESS_MSG : CommonVariables.FAILURE_MSG)
                .status(Objects.nonNull(response.getStatus()) ? response.getStatus() : 0)
                .data(response).build();
    }
}
