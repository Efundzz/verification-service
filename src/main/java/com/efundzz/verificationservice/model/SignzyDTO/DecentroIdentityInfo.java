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

    public ArrayList<DecentroPANId> getpANId() {
        return pANId;
    }

    public void setpANId(ArrayList<DecentroPANId> pANId) {
        this.pANId = pANId;
    }

    public ArrayList<DecentroRationCard> getRationCard() {
        return rationCard;
    }

    public void setRationCard(ArrayList<DecentroRationCard> rationCard) {
        this.rationCard = rationCard;
    }

    public ArrayList<DecentroOtherId> getOtherId() {
        return otherId;
    }

    public void setOtherId(ArrayList<DecentroOtherId> otherId) {
        this.otherId = otherId;
    }
}
