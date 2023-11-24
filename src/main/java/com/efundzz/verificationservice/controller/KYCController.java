package com.efundzz.verificationservice.controller;

import com.efundzz.verificationservice.client.AuthBridgeClient;
import com.efundzz.verificationservice.mapper.PanMapper;
import com.efundzz.verificationservice.model.CibilScoreRequestDTO;
import com.efundzz.verificationservice.model.EquifaxScoreRequestDTO;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.SignzyDTO.PanResponse;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;
import com.efundzz.verificationservice.model.cin.CinABResponse;
import com.efundzz.verificationservice.model.gst.GstABResponse;
import com.efundzz.verificationservice.model.pan.AdvancedPANRequestDTO;
import com.efundzz.verificationservice.service.KYCService;
import com.efundzz.verificationservice.util.AesCbcCrypto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kyc")
public class KYCController {

    private KYCService kycService;
    private AuthBridgeClient authBridgeClient;
    private PanMapper panMapper;
    ObjectMapper mapper = new ObjectMapper();

    String key = "R@za#401";
    String iv = AesCbcCrypto.getIV();

    public KYCController(KYCService kycService, AuthBridgeClient authBridgeClient,PanMapper panMapper) {
        this.kycService = kycService;
        this.authBridgeClient = authBridgeClient;
        this.panMapper = panMapper;
    }

    @PostMapping("/pan")
    public ResponseEntity<AuthbridgeDecryptedResponseDTO> getPanNumber(@RequestBody IDSearchRequestDTO panRequestDTO) {
        // use open feign to call the KYC service
        // pass the PAN number as a request body
        GenericApiResponse<AuthbridgeDecryptedResponseDTO> response = kycService.fetchPanDetails(panRequestDTO);

        if(1 != response.getStatus()) throw new RuntimeException(response.getMessage());
        return ResponseEntity.ok(response.getData());
    }

    //Signzy Pan Api
    @PostMapping("/signzy/pan")
    public ResponseEntity<AuthbridgeDecryptedResponseDTO<PanResponse>> getPanNumber1(@RequestBody IDSearchRequestDTO panRequestDTO) {
        // use open feign to call the KYC service
        // pass the PAN number as a request body
        GenericApiResponse<AuthbridgeDecryptedResponseDTO> response = kycService.fetchPanDetails(panRequestDTO);

        if (1 != response.getStatus()) { throw new RuntimeException(response.getMessage()); }
        AuthbridgeDecryptedResponseDTO<PanResponse> mappedResponse = panMapper.mapToAuthbridgeResponse((PanResponse) response.getData().getMsg());

        return ResponseEntity.ok(mappedResponse);
    }
//    @PostMapping("/sigPan")
//    public ResponseEntity<AuthbridgeDecryptedResponseDTO<PanResponse>> getPanNumber2(@RequestBody IDSearchRequestDTO panRequestDTO) {
//        // use open feign to call the KYC service
//        // pass the PAN number as a request body
//        GenericApiResponse<AuthbridgeDecryptedResponseDTO> response = kycService.fetchPanDetails(panRequestDTO);
//
//        if (1 != response.getStatus()) { throw new RuntimeException(response.getMessage()); }
//      //  AuthbridgeDecryptedResponseDTO<PanResponse> mappedResponse = panMapper.mapToAuthbridgeResponse((PanResponse) response.getData().getMsg());
//
//        return ResponseEntity.ok(response.getData());
//    }
    //Signzy Pan Api without merge
    @PostMapping("/signzyPan")
    public PanResponse panValidation(@RequestBody IDSearchRequestDTO panRequestDTO) {
        return kycService.panValidation(panRequestDTO);
    }

    @PostMapping("/advance_pan")
    public ResponseEntity<AuthbridgeDecryptedResponseDTO> getAdvancedPAN(@RequestBody AdvancedPANRequestDTO panRequestDTO) {
        // use open feign to call the KYC service
        // pass the PAN number as a request body

        GenericApiResponse<AuthbridgeDecryptedResponseDTO> response = kycService.getAdvancedPanDetails(panRequestDTO);

        if(1 != response.getStatus()) throw new RuntimeException(response.getMessage());
        return ResponseEntity.ok(response.getData());
    }

    @PostMapping("/equifax_score")
    public ResponseEntity<Object> getEquifaxScore(@RequestBody EquifaxScoreRequestDTO equifaxScoreRequestDTO) {
        try {
            String requestString = mapper.writeValueAsString(equifaxScoreRequestDTO);
            String encryptedRequest = AesCbcCrypto.encrypt(key, iv, requestString);

            System.out.println(encryptedRequest);
            AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO = new AuthbridgeEncryptedRequestDTO(encryptedRequest);


            AuthbridgeEncryptedResponseDTO authbridgeEncryptedResponseDTO = authBridgeClient.eqifaxScore(authbridgeEncryptedRequestDTO);

            String jsonString = AesCbcCrypto.decrypt(key, authbridgeEncryptedResponseDTO.getResponseData());



            return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/cibil_score_generate_otp")
    public ResponseEntity<Object> getCibilOTP(@RequestBody CibilScoreRequestDTO cibilScoreRequestDTO) {
        try {
            String requestString = mapper.writeValueAsString(cibilScoreRequestDTO);
            String encryptedRequest = AesCbcCrypto.encrypt(key, iv, requestString);

            System.out.println(encryptedRequest);
            AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO = new AuthbridgeEncryptedRequestDTO(encryptedRequest);


            AuthbridgeEncryptedResponseDTO authbridgeEncryptedResponseDTO = authBridgeClient.cibilScore(authbridgeEncryptedRequestDTO);

            String jsonString = AesCbcCrypto.decrypt(key, authbridgeEncryptedResponseDTO.getResponseData());



            return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/gst/fetchDetails")
    public ResponseEntity<GenericApiResponse<GstABResponse>> fetchGstDetails(@RequestBody IDSearchRequestDTO gstDetails) {
        GenericApiResponse<GstABResponse> response = kycService.fetchGstDetails(gstDetails);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }

    @PostMapping("/cin/fetchDetails")
    public ResponseEntity<GenericApiResponse<CinABResponse>> fetchCinDetails(@RequestBody IDSearchRequestDTO cinDetails) {
        GenericApiResponse<CinABResponse> response = kycService.fetchCINResponse(cinDetails);
        return (response.getStatus() == 1) ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().body(response);
    }
}
