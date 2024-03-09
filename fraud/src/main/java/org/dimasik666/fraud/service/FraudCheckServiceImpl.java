package org.dimasik666.fraud.service;

import lombok.extern.slf4j.Slf4j;
import org.dimasik666.fraud.domain.model.FraudCheckHistory;
import org.dimasik666.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public record FraudCheckServiceImpl(FraudCheckHistoryRepository fraudCheckHistoryRepository)
        implements FraudCheckService {

    public boolean isFraudulentCustomer(long customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                                 .customerId(customerId)
                                 .isFraudster(false)
                                 .createdAt(LocalDateTime.now())
                                 .build()
        );
        return false;
    }
}
