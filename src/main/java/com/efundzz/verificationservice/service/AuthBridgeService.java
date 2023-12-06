package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;
import com.efundzz.verificationservice.model.enums.EfundzzErrorMessages;
import com.efundzz.verificationservice.model.enums.KycStepName;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.efundzz.verificationservice.util.EfundzzException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class AuthBridgeService {

    private final PersistenceService persistenceService;

    ObjectMapper mapper = new ObjectMapper();
    TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String,Object>>() {};

    public AuthBridgeService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    public <T> AuthbridgeDecryptedResponseDTO<T> callAuthBridge(String transId, KycStepName step, Object request, AuthBridgeFunction abFunction, Class responseClass) throws EfundzzException{
        AuthbridgeDecryptedResponseDTO<T> response = new AuthbridgeDecryptedResponseDTO<>();
        boolean isException = true;
        AuthbridgeEncryptedResponseDTO encryptedResponse = new AuthbridgeEncryptedResponseDTO();
        String decryptedResponse = "";
        try {
            persistenceService.saveAuditLog(transId, step.getValue(), mapper.writeValueAsString(request), "REQUEST", false);
            log.info("Request sent for {}, transaction id- {} : {}", step.getValue(), transId, mapper.writeValueAsString(request));
            //TODO: Commented out the api call to prevent api calls during local testing
            encryptedResponse = abFunction.call();
            log.info("Received response for {},transaction id- {}", step.getValue(), transId);
            log.debug("Step - {}, transaction id - {}, encryptedResponse - {}", step.getValue(), transId, encryptedResponse);

            if(Objects.nonNull(encryptedResponse)) {
                decryptedResponse = AesCbcCrypto.decryptResponse(encryptedResponse);
                JavaType type = mapper.getTypeFactory().constructParametricType(AuthbridgeDecryptedResponseDTO.class, responseClass);
                response = mapper.readValue(decryptedResponse, type);
                persistenceService.saveKycDetails(step, transId, response.getTsTransID(), mapper.convertValue(response, typeReference));
                isException = false;
            }
        }
        catch (FeignException e) {
            log.error("Error: {} - {}", step.getValue(), e.getMessage());
            persistenceService.saveKycDetails(step, transId, response.getTsTransID(), fetchResponse(e.contentUTF8()));
            decryptedResponse = StringUtils.isBlank(e.contentUTF8()) ? e.getMessage() : e.contentUTF8();
        }
        catch (Exception e) {
            log.error("Error:{} - {}", step.getValue(), e.getMessage());
            if(decryptedResponse.equals(StringUtils.EMPTY)) decryptedResponse = encryptedResponse.getResponseData();
        }
        persistenceService.saveAuditLog(transId, step.getValue(), decryptedResponse, "RESPONSE", isException);
        if(Objects.isNull(response.getStatus()) || 1 != response.getStatus()) throwError(decryptedResponse);
        return response;
    }

    private Map<String, Object> fetchResponse(String strContent) {
        try {
            strContent = StringUtils.isBlank(strContent) ? "" : strContent;
            return mapper.readValue(strContent, Map.class);
        } catch (JsonProcessingException e) {
            log.error("Error while converting feign error response to map - {}", e.getMessage());
        }
        return null;
    }

    private void throwError(String decryptedResponse) {
        //convert decryptedResponse to map
        Map<String, Object> decryptedResponseMap = fetchResponse(decryptedResponse);
        String msg = Optional.ofNullable(decryptedResponseMap).map(map -> map.get("msg")).map(Object::toString).orElse("");
        throw new EfundzzException(StringUtils.isBlank(msg) ? EfundzzErrorMessages.SOMETHING_WENT_WRONG.getEfundzMsg() : msg);
    }
}
