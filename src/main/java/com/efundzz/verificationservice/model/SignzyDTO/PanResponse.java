package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PanResponse{
    private Essentials essentials;
    private String id;
    private String patronId;
    private String task;
    private PanResult result;

}


