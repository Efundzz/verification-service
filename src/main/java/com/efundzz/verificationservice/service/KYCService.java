package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.client.SignzyClient;
import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.SignzyDTO.Essentials;
import com.efundzz.verificationservice.model.SignzyDTO.PanRequest;
import com.efundzz.verificationservice.model.SignzyDTO.PanResponse;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.cin.CinABResponse;
import com.efundzz.verificationservice.model.gst.GstABResponse;
import com.efundzz.verificationservice.model.pan.AdvancedPANRequestDTO;
import com.efundzz.verificationservice.util.CommonVariables;
import org.springframework.stereotype.Service;

@Service
public class KYCService {

    private PANService panService;
    private SignzyClient signzyClient;
    private GSTService gstService;
    private CINService cinService;

    public KYCService(PANService panService, GSTService gstService, CINService cinService,SignzyClient signzyClient) {
        this.panService = panService;
        this.signzyClient = signzyClient;
    }
    public PanResponse panValidation(IDSearchRequestDTO panRequestDTO) {
        PanRequest panRequest = new PanRequest();
        Essentials essentials = new Essentials();
        panRequest.setTask("fetch");
        essentials.setNumber(panRequestDTO.getDocNumber());
        panRequest.setEssentials(essentials);

        return signzyClient.signzyPan(panRequest, CommonVariables.panAuth);
    }

    public GenericApiResponse<AuthbridgeDecryptedResponseDTO> fetchPanDetails(IDSearchRequestDTO panRequestDTO) {
        return panService.fetchPanDetails(panRequestDTO);
    }

    public GenericApiResponse<AuthbridgeDecryptedResponseDTO> getAdvancedPanDetails(AdvancedPANRequestDTO panRequestDTO) {
        return panService.getAdvancedPanDetails(panRequestDTO);
    }

    public GenericApiResponse<GstABResponse> fetchGstDetails(IDSearchRequestDTO gstDetails) {
        return gstService.fetchGstResponse(gstDetails);
    }

    public GenericApiResponse<CinABResponse> fetchCINResponse(IDSearchRequestDTO cinDetails) {
        return cinService.fetchCINResponse(cinDetails);
    }
}
