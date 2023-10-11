package com.efundzz.verificationservice.model.gst;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GstABResponse {
    @JsonAlias("GSTIN/ UIN")
    private String gstin;

    @JsonAlias("Legal Name of Business")
    private String legalBusinessName;

    @JsonAlias("Trade Name")
    private String tradeName;

    @JsonAlias("Date of registration")
    private String dateOfRegistration;

    @JsonAlias("ConstitutionOfBusiness")
    private String constitutionOfBusiness;

    @JsonAlias("AdministrativeOffice")
    private String administrativeOffice;

    @JsonAlias("OtherOffice")
    private String otherOffice;

    @JsonAlias("Taxpayer Type")
    private String taxpayerType;

    @JsonAlias("GSTIN / UIN Status")
    private String gstinStatus;

    @JsonAlias("Date of Cancellation")
    private String dateOfCancellation;

    @JsonAlias("AnnualAggregateTurnover")
    private String annualAggregateTurnover;

    @JsonAlias("GrossTotalIncome")
    private String grossTotalIncome;

    @JsonAlias("PercentageOfTaxPaymentInCash")
    private String percentageOfTaxPaymentInCash;

    @JsonAlias("WhetherAadhaarAuthenticated")
    private String isAadhaarAuthenticated;

    @JsonAlias("WhetherE-KYCVerified")
    private String eKYCVerified;

    @JsonAlias("NatureOfCoreBusinessActivity")
    private String natureOfCoreBusinessActivity;

    @JsonAlias("NatureOfBusinessActivities")
    private String natureOfBusinessActivities;

    @JsonAlias("proprietor_name")
    private List<String> proprietorName;

    @JsonAlias("field_visit_conducted")
    private String fieldVisitConducted;

    @JsonAlias("goods_n_service")
    private Object goodsAndService;

    @JsonAlias("placeOfBusinessData")
    private List<GstABPlaceOfBusinessData> placeOfBusinessData;

    @JsonAlias("filingData")
    private Object filingData;
}
