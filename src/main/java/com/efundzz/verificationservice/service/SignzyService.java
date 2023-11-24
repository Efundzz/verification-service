package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.DecentroClient;
import com.efundzz.verificationservice.client.SignzyClient;
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
    //    //signzy pan validation
//    public PanResponse panValidation(IDSearchRequestDTO panRequestDTO) {
//        PanRequest panRequest = new PanRequest();
//        Essentials essentials = new Essentials();
//        panRequest.setTask("fetch");
//        panRequest.setEssentials(essentials);
//        essentials.setNumber(panRequestDTO.getDocNumber());;
////        PanResponse panResponse = new PanResponse();
////        PanResult panResult = new PanResult();
////        panResult.setFirstName(AuthbridgeEncryptedResponseDTO);
//
//        return signzyClient.signzyPan(panRequest, CommonVariables.panAuth);
//    }
    public VerifyAadharResponseBody verifyAadhar(VerifyAadharRequest verifyAadharRequest)
    {
        verifyAadharRequest.setService(CommonVariables.Service);
        verifyAadharRequest.setTask(CommonVariables.Aadhar_task);
        verifyAadharRequest.setAccessToken(CommonVariables.Aadhar_AccessToken);
        verifyAadharRequest.setItemId(CommonVariables.Aadhar_ItemId);
        return signzyClient.verifyAadhar(verifyAadharRequest);
    }
    public PanAadharResponseBody statusCheck(PanAadharRequest requestDto) {
        requestDto.setService(CommonVariables.Service);
        requestDto.setItemId(CommonVariables.PanAadhar_ItemId);
        requestDto.setTask(CommonVariables.PanAadhar_task);
        requestDto.setAccessToken(CommonVariables.PanAadhar_AccessToken);
        return signzyClient.linkedStatus(requestDto);
    }
    public EmailResponse emailValidation(EmailRequest emailRequest)
    {
        return signzyClient.VerifyEmail(emailRequest, CommonVariables.emailAuth);
    }
    //decentro credit report
    public DecentroResponse decentroCredit(DecentroRequest decentroRequest) {
        decentroRequest.setConsent(CommonVariables.Decentro_consent);
        decentroRequest.setConsent_purpose(CommonVariables.Decentro_ConsentPurpose);
        decentroRequest.setInquiry_purpose(CommonVariables.Decentro_Inquiry_Purpose);
        return decentroClient.decentroCreditReport(decentroRequest, CommonVariables.CLIENT_ID,CommonVariables.CLIENT_SECRET,CommonVariables.MODULE_SECRET,CommonVariables.PROVIDER_SECRET);
    }
}
