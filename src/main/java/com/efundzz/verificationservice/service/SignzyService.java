package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.DecentroClient;
import com.efundzz.verificationservice.client.SignzyClient;
import com.efundzz.verificationservice.model.EmailRequestDTO;
import com.efundzz.verificationservice.model.KycRequestDTO;
import com.efundzz.verificationservice.model.PanAadharRequestDTO;
import com.efundzz.verificationservice.model.SignzyDTO.*;
import com.efundzz.verificationservice.util.CommonVariables;
import org.springframework.stereotype.Service;

@Service
public class SignzyService {
    private SignzyClient signzyClient;
    private DecentroClient decentroClient;
    public SignzyService(SignzyClient signzyClient,DecentroClient decentroClient){
        this.signzyClient = signzyClient;
        this.decentroClient = decentroClient;
    }
    public VerifyAadharResponseBody verifyAadhar(KycRequestDTO verifyAadharRequest)
    {
        VerifyAadharRequest verifyAadharRequest1 = new VerifyAadharRequest();
        Essentials essentials = new Essentials();
        essentials.setUid(verifyAadharRequest.getDocNumber());
        verifyAadharRequest1.setEssentials(essentials);
        verifyAadharRequest1.setService(CommonVariables.Service);
        verifyAadharRequest1.setTask(CommonVariables.Aadhar_task);
        verifyAadharRequest1.setAccessToken(CommonVariables.Aadhar_AccessToken);
        verifyAadharRequest1.setItemId(CommonVariables.Aadhar_ItemId);
        return signzyClient.verifyAadhar(verifyAadharRequest1);
    }
    public PanAadharResponseBody panAadharLinked(PanAadharRequestDTO panAadhar) {
        PanAadharRequest panAadharRequest = new PanAadharRequest();
        Essentials essentials = new Essentials();
        panAadharRequest.setEssentials(essentials);
        essentials.setNumber(panAadhar.getPanNumber());
        essentials.setUid(panAadhar.getAadharNumber());
        panAadharRequest.setService(CommonVariables.Service);
        panAadharRequest.setItemId(CommonVariables.PanAadhar_ItemId);
        panAadharRequest.setTask(CommonVariables.PanAadhar_task);
        panAadharRequest.setAccessToken(CommonVariables.PanAadhar_AccessToken);
        return signzyClient.linkedStatus(panAadharRequest);
    }
    public EmailResponse emailValidation(EmailRequestDTO emailRequest)
    {
        EmailRequest emailRequest1 = new EmailRequest();
        Essentials essentials = new Essentials();
        essentials.setEmailId(emailRequest.getEmailID());
        emailRequest1.setEssentials(essentials);
        return signzyClient.VerifyEmail(emailRequest1, CommonVariables.emailAuth);
    }
    public DecentroResponse decentroCredit(DecentroRequest decentroRequest) {
        decentroRequest.setConsent(CommonVariables.Decentro_consent);
        decentroRequest.setConsent_purpose(CommonVariables.Decentro_ConsentPurpose);
        decentroRequest.setInquiry_purpose(CommonVariables.Decentro_Inquiry_Purpose);
        return decentroClient.decentroCreditReport(decentroRequest, CommonVariables.CLIENT_ID,CommonVariables.CLIENT_SECRET,CommonVariables.MODULE_SECRET,CommonVariables.PROVIDER_SECRET);
    }
}
