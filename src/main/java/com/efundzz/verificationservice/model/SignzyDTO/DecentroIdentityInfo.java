package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroIdentityInfo {
    private ArrayList<DecentroPANId> pANId;
    private ArrayList<DecentroRationCard> rationCard;
    private ArrayList<DecentroOtherId> otherId;
}
