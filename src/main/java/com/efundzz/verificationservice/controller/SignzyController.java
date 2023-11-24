package com.efundzz.verificationservice.controller;

import com.efundzz.verificationservice.model.SignzyDTO.*;
import com.efundzz.verificationservice.service.SignzyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signzy")
public class SignzyController {
    private SignzyService signzyService;
    public SignzyController(SignzyService signzyService)
    {
        this.signzyService = signzyService;

    }
    //    @PostMapping("/Pan")
//    public PanResponse panValidation(@RequestBody IDSearchRequestDTO panRequestDTO) {
//        return kycService.panValidation(panRequestDTO);
//    }
    @PostMapping("/verifyAadhar")
    public VerifyAadharResponseBody verifyAadhar(@RequestBody VerifyAadharRequest verifyAadharRequest)
    {
        return signzyService.verifyAadhar(verifyAadharRequest);
    }
    @PostMapping("/panAadharLink")
    public PanAadharResponseBody linkedStatus(@RequestBody PanAadharRequest requestDto) {
        return signzyService.statusCheck(requestDto);
    }
    @PostMapping("/email")
    public EmailResponse VerifyGstin(@RequestBody  EmailRequest emailRequest)
    {
        return signzyService.emailValidation(emailRequest);
    }
    @PostMapping("/creditReport")
    public DecentroResponse creditReport(@RequestBody DecentroRequest decentroRequest)
    {
        return signzyService.decentroCredit(decentroRequest);
    }
}
