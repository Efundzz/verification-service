package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecentroIDAndContactInfo {
    private DecentroPersonalInfo personalInfo;
    private DecentroIdentityInfo identityInfo;
    private List<DecentroAddressInfo> addressInfo;
    private List<DecentroPhoneInfo> phoneInfo;

    public DecentroPersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(DecentroPersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public DecentroIdentityInfo getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(DecentroIdentityInfo identityInfo) {
        this.identityInfo = identityInfo;
    }

    public List<DecentroAddressInfo> getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(List<DecentroAddressInfo> addressInfo) {
        this.addressInfo = addressInfo;
    }

    public List<DecentroPhoneInfo> getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(List<DecentroPhoneInfo> phoneInfo) {
        this.phoneInfo = phoneInfo;
    }
}
