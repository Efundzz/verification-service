package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroRecentActivities {
    private String accountsDelinquent;
    private String accountsOpened;
    private String totalInquiries;
    private String accountsUpdated;
}
