package org.dimasik666.clients.fraud;

import org.dimasik666.clients.fraud.domain.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud-check{customerId}")
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") long customerID);
}
