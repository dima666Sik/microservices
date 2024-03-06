package org.dimasik666.service;

import org.dimasik666.domain.dto.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}
