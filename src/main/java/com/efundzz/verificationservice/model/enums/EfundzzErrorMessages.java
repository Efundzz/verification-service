package com.efundzz.verificationservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum EfundzzErrorMessages {

    OTP_EXPIRED(1079, "Otp expired", "OTP timed out, please resend and try again"),
    TECHNICAL_ERROR(1055, "Some technical error. Please try after sometime.", "We are facing technical issues, try again later"),
    TRANS_ID_NOT_SET(1056, "transID is not set.", "Kindly set the transID for processing request"),
    CITY_REQUIRED(1139, "City is required.", "Please enter your city name"),
    RATE_LIMIT_REACHED(1379, "Too many requests for this operation, rate limit reached", "Too many requests, please slowdown and try again later"),
    SOMETHING_WENT_WRONG(0, "Something went wrong, please try again.", "Oops! Something went wrong, try again later"),
    INVALID_GSTIN_NUMBER(1069, "Invalid GSTIN number.", "Please enter a valid GSTIN number"),
    TRANSACTION_ALREADY_COMPLETED(0, "Transaction already completed. It is duplicate request.", "It appears that the transaction has already been successfully processed.It appears to be a duplicate request, kindly verify"),
    VERIFICATION_ATTEMPT_FAILED(1079, "Verification attempt failed", "Verification attempt was not successful, please try again"),
    INVALID_OTP(1179, "OTP entered is invalid", "Please enter a valid otp"),
    DOC_NUMBER_REQUIRED(1014, "docNumber is required.", "Kindly provide the document number for processing your request"),
    MOBILE_CODE_REQUIRED(1026, "Mobilecode required", "Kindly provide the Mobile code for processing your request"),
    TRANS_ID_REQUIRED(1018, "transID required", "Kindly provide the transID for processing request"),
    PINCODE_REQUIRED(1140, "Pincode is required.", "Please enter your PIN Code"),
    INVALID_MOBILE_CODE(1027, "invalid mobilecode", "Please enter a valid mobilecode"),
    UNAUTHORIZED(401, "Unauthorized", "[401 Unauthorized] during [POST] to [https://www.truthscreen.com/PanVerification/request] [AuthBridgeClient#verifyAdvancedPan(AuthbridgeEncryptedRequestDTO)]: []"),
    NO_RECORD_FOUND(0, "No Record Found.", "We couldn't locate any records matching your criteria."),
    INVALID_AADHAAR_NUMBER(1095, "Please enter valid aadhaar number.", "Please enter valid aadhaar number."),
    READ_TIMED_OUT(0, "Read timed out", "Read timed out executing POST https://www.truthscreen.com/api/v2.2/idsearch"),
    LAST_NAME_REQUIRED(1135, "Last Name is required.", "please enter your last name");

    private final int code;
    private final String authBridgeMsg;
    private final String efundzMsg;
    public static String getEfundzzMsg(String authBridgeMsg) {
        return Stream.of(EfundzzErrorMessages.values()).filter(msgs -> msgs.authBridgeMsg == authBridgeMsg)
                .findFirst().map(EfundzzErrorMessages::getEfundzMsg).orElse(authBridgeMsg);
    }
}
