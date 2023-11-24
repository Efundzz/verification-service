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
}
