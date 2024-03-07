package org.dimasik666.service;

import org.dimasik666.domain.dto.FraudCheckResponse;

public interface FraudCheckService {
    boolean isFraudulentCustomer(Integer customerId);
}
