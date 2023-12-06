package com.efundzz.verificationservice.controller;

import com.efundzz.verificationservice.ErrorHandling.InvalidRequestException;
import com.efundzz.verificationservice.model.EmailRequestDTO;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.PanAadharRequestDTO;
import com.efundzz.verificationservice.model.SignzyDTO.*;
import com.efundzz.verificationservice.service.SignzyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignzyController {
    private SignzyService signzyService;
    public SignzyController(SignzyService signzyService)
    {
        this.signzyService = signzyService;
    }

    @PostMapping("/aadhar")
    public ResponseEntity<VerifyAadharResponseBody> verifyAadhar(@RequestBody KycRequestDTO verifyAadharRequest) {
        VerifyAadharResponseBody response = signzyService.verifyAadhar(verifyAadharRequest);
        if (response == null) {
            throw new InvalidRequestException("Aadhar Response is null.");
        }
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/pan/aadhar")
    public ResponseEntity<PanAadharResponseBody> linkedStatus(@Valid @RequestBody PanAadharRequestDTO requestDto) {
        PanAadharResponseBody response = signzyService.panAadharLinked(requestDto);
        if (response == null) {
            throw new InvalidRequestException("Pan Aadhar Linked Status Response is null.");
        }
        return ResponseEntity.ok().body(response);

    }
    @PostMapping("/email")
    public ResponseEntity<EmailResponse> emailVerification(@RequestBody EmailRequestDTO emailRequest)
    {
       EmailResponse response = signzyService.emailValidation(emailRequest);
       if(response == null)
       {
           throw new InvalidRequestException("Email Response is Null.");
       }
       return ResponseEntity.ok().body(response);
    }
    @PostMapping("/creditReport")
    public ResponseEntity<DecentroResponse> creditReport(@RequestBody DecentroRequest decentroRequest)
    {
        DecentroResponse response = signzyService.decentroCredit(decentroRequest);
        if(response == null)
        {
            throw new InvalidRequestException("Credit Response Body Null.");
        }
        return ResponseEntity.ok().body(response);
    }
}
