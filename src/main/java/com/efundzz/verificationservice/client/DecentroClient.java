package com.efundzz.verificationservice.client;

import com.efundzz.verificationservice.model.SignzyDTO.DecentroRequest;
import com.efundzz.verificationservice.model.SignzyDTO.DecentroResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "decentro", url = "https://in.decentro.tech/v2/financial_services/credit_bureau/credit_report")
public interface DecentroClient {
    @PostMapping("/summary")
    DecentroResponse decentroCreditReport(
            @RequestBody DecentroRequest decentroRequest,
            @RequestHeader("CLIENT-ID") String clientId,
            @RequestHeader("CLIENT-SECRET") String clientSecret,
            @RequestHeader("MODULE-SECRET") String moduleSecret,
            @RequestHeader("PROVIDER-SECRET") String providerSecret
    );
}
