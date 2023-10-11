package com.efundzz.verificationservice.model.cin;

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
public class CinABResponse {
    private String cin;
    private String company_name;
    private String roc_id;
    private String roc_code;
    private String registration_no;
    private String company_category;
    private String company_sub_category;
    private String class_of_company;
    private String authorised_capital;
    private String paid_up_capital;
    private String no_of_members;
    private String date_of_incorporation;
    private String registered_address;
    private String address_books_of_account_paper_maintained;
    private String suspended_stock_exchange;
    private String email_id;
    private String whether_listed_or_not;
    private String date_of_last_agm;
    private String date_of_balance_sheet;
    private String number_of_designated_partners;
    private String previous_firm;
    private String no_of_patterns;
    private String total_obligation_of_contribution;
    private String main_division_of_business;
    private String description_of_main_division;
    private String end_date_for_accounts_solvency_filed;
    private String end_date_for_annual_returned_filed;
    private String country_of_incorporation;
    private String foreign_company_with_share_capital;
    private String type_of_office;
    private String details;
    private String sum_of_active_charges;
    private String sum_of_satisfied_sharges;
    private String registered_office;
    private String global_location_number;
    private String activity_code;
    private String activity_description;
    private String previous_company_firm_details;
    private String company_pan;
    private String date_of_annual_return_filing;
    private String telephone;
    private String fax;
    private String website;
    private String address_line1;
    private String address_line2;
    private String address_state;
    private String address_city;
    private String address_country;
    private String address_pincode;
    private String listing_status;
    private String defaulting_status;
    private String company_status;
    private String api_status;
    private String signatory_modified;
    private String master_id;
    private String index_of_charges_status;
    private String director_status;
    private String company_charge_new_status;
    private String company_charges_status;
    private String other_address;
    private String suspended_at_stock_exchange;
    private String update_btn_info;
    private String line_of_business;
    private String is_gstin_pan_sync;
    private List<Object> MasterDirector;
}
