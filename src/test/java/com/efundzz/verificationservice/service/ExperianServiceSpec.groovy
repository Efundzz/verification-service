package com.efundzz.verificationservice.service

import com.efundzz.verificationservice.client.AuthBridgeClient
import com.efundzz.verificationservice.model.authbridge.AuthbridgeDecryptedResponseDTO
import com.efundzz.verificationservice.model.experian.ExperianABMsgData
import com.efundzz.verificationservice.model.experian.ExperianABPersona
import com.efundzz.verificationservice.model.experian.ExperianABVerifyOtpMsg
import spock.lang.Specification

class ExperianServiceSpec extends Specification{

    ExperianService experianService;
    AuthBridgeService authBridgeService = Mock(AuthBridgeService)
    AuthBridgeClient authBridgeClient = Mock(AuthBridgeClient)
    PersistenceService persistenceService = Mock(PersistenceService)

    def setup() {
        experianService = new ExperianService(authBridgeService, authBridgeClient, persistenceService)
        persistenceService.saveStepData(_, _, _) >> null
    }

    def "Test isCreditScoreEligible for null checks"() {
        given:
            def transId = "123456"
            def response = AuthbridgeDecryptedResponseDTO<ExperianABVerifyOtpMsg>.builder().msg(msg).build()
        when:
            boolean isEligible = experianService.isCreditScoreEligible(transId, response)
        then:
            noExceptionThrown()
            isEligible == expectedEligibility
        where:
            expectedEligibility | msg
            true                | ExperianABVerifyOtpMsg.builder().data(ExperianABMsgData.builder()
                                    .persona(ExperianABPersona.builder().credit_score("NH").build()).build()).build()
            false               | ExperianABVerifyOtpMsg.builder().data(ExperianABMsgData.builder().persona(new ExperianABPersona()).build()).build()
            false               | ExperianABVerifyOtpMsg.builder().data(ExperianABMsgData.builder().persona(null).build()).build()
            false               | ExperianABVerifyOtpMsg.builder().data(null).build()
            false               | new ExperianABVerifyOtpMsg()
            false               | null
    }

    def "Test isCreditScoreEligible when creditscore is #"() {
        given:
        def transId = "123456"
        def response = AuthbridgeDecryptedResponseDTO<ExperianABVerifyOtpMsg>.builder()
                .msg(ExperianABVerifyOtpMsg.builder()
                        .data(ExperianABMsgData.builder()
                                .persona(ExperianABPersona.builder()
                                        .credit_score(credit_score).build()).
                                build()).build()).build()
        when:
        boolean isEligible = experianService.isCreditScoreEligible(transId, response)
        then:
        noExceptionThrown()
        isEligible == expectedEligibility
        where:
        credit_score    || expectedEligibility
        "A+"            || true
        "A"             || true
        "B"             || true
        "C"             || true
        "D"             || true
        "E"             || true
        "NH"            || true
        "S"             || false
    }

}
