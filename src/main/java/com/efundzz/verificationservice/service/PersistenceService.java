package com.efundzz.verificationservice.service;

import com.efundzz.dbconnect.entity.AuditLog;
import com.efundzz.dbconnect.entity.KycModel;
import com.efundzz.dbconnect.entity.StepData;
import com.efundzz.dbconnect.repo.AuditLogRepository;
import com.efundzz.dbconnect.repo.KycRepository;
import com.efundzz.dbconnect.repo.StepDataRepository;
import com.efundzz.verificationservice.model.enums.KycStepName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersistenceService {

    @Autowired
    KycRepository kycRepository;

    @Autowired
    private StepDataRepository stepDataRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public KycModel saveKycDetails(KycStepName stepName, String transID, String abTransID, Map<String, Object> abData) {
        return kycRepository.save(KycModel.builder()
                .kycStepName(stepName.getValue())
                .transID(transID)
                .authBridgeTransID(abTransID)
                .authBridgeData(abData).build());
    }

    public KycModel updateTsTransIdToKycDetails(String transId, KycStepName stepName, String tsTransId) {
        KycModel kycModel = findFirstByTransIDAndKycStepNameOrderByIdDesc(transId, stepName);
        kycModel.setAuthBridgeTransID(tsTransId);
        return kycRepository.save(kycModel);
    }

    public KycModel findFirstByTransIDAndKycStepNameOrderByIdDesc(String transID, KycStepName stepName) {
        return kycRepository.findFirstByTransIDAndKycStepNameOrderByIdDesc(transID, stepName.getValue());
    }

    public KycModel findById(Long id) {
        return kycRepository.findById(id).get();
    }

    public List<StepData> getStepsByStepName(String id, List<String> stepNames) {
        return stepDataRepository.getStepsByStepName(id, stepNames);
    }

    public StepData saveStepData(String transID, String stepName, Map<String, Object> data) {
        StepData stepData = StepData.builder()
                .applicationId(transID)
                .stepName(stepName)
                .data(data).build();
        Optional.ofNullable(stepDataRepository.findTopByApplicationIdAndStepName(transID, stepName)).ifPresent(e -> {
            stepData.setId(e.getId());
            stepData.setCreatedDT(e.getCreatedDT());
        });
        return stepDataRepository.save(stepData);
    }

    public AuditLog saveAuditLog(String transId, String stepName, String data, String dataType, boolean isException) {
        return auditLogRepository.save(AuditLog.builder()
                        .transID(transId)
                        .stepName(stepName)
                        .data(data)
                        .dataType(dataType)
                        .isException(isException ? "Yes" : "No")
                .build());
    }

}
