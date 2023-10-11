package com.efundzz.verificationservice.model.gst;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GstABPlaceOfBusinessData {

    private String type;
    private String nature_of_business_activities;
    private String address;
    private String contact_details;
}
