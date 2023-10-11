package com.efundzz.verificationservice.service;

import com.efundzz.verificationservice.model.GenericApiResponse;
import com.efundzz.verificationservice.model.IDSearchRequestDTO;
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO;
import com.efundzz.verificationservice.model.cin.CinABResponse;
import com.efundzz.verificationservice.model.gst.GstABResponse;
import com.efundzz.verificationservice.model.pan.AdvancedPANRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class KYCService {

    private PANService panService;
    private GSTService gstService;
    private CINService cinService;

    public KYCService(PANService panService, GSTService gstService, CINService cinService) {
        this.panService = panService;
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
