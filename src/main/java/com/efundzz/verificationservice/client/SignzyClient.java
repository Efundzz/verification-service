package com.efundzz.verificationservice.client;

import com.efundzz.verificationservice.model.SignzyDTO.*;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeEncryptedResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "signzy", url = "https://signzy.tech/api/v2")
public interface SignzyClient {
    @PostMapping("/patrons/login")
    AuthenticationResponse createAuthentication(@RequestBody AuthenticationRequest authenticationRequest);

    @PostMapping("/patrons/650bb98d09e2f4003ee88ae6/identities")
    IdentitiesResponse createIdentities(@RequestBody IdentitiesRequest identitiesRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping("/snoops")
    PanAadharResponseBody linkedStatus(@RequestBody PanAadharRequest requestDto);

    @PostMapping("/snoops")
    VerifyAadharResponseBody verifyAadhar(@RequestBody VerifyAadharRequest verifyAadharRequest);

    @PostMapping("/patrons/650bb98d09e2f4003ee88ae6/gstns")
    GSTINResponse VerifyGstin(@RequestBody GSTINRequest gstinRequest,@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping("/patrons/650bb98d09e2f4003ee88ae6/emailvalidations")
    EmailResponse VerifyEmail(@RequestBody EmailRequest emailRequest,@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping("/patrons/650bb98d09e2f4003ee88ae6/panv2")
    AuthbridgeEncryptedResponseDTO signzyPan(@RequestBody AuthbridgeEncryptedRequestDTO authbridgeEncryptedRequestDTO);
    @PostMapping("/patrons/650bb98d09e2f4003ee88ae6/panv2")
    PanResponse signzyPan(PanRequest panRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);
}
