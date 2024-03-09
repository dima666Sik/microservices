package org.dimasik666.fraud.controller;

import lombok.extern.slf4j.Slf4j;
import org.dimasik666.clients.fraud.FraudClient;
import org.dimasik666.clients.fraud.domain.dto.FraudCheckResponse;
import org.dimasik666.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public record FraudController(FraudCheckService fraudCheckService)
        implements FraudClient {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") long customerID) {

        boolean isFraudulentCustomer = fraudCheckService.
                isFraudulentCustomer(customerID);

        log.info("fraud check request for customer {}", customerID);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
