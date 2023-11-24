package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GSTINResponse {
    public String task;
    public Essentials essentials;
    private String id;
    private String patronId;
    private GSTINResult result;
}
