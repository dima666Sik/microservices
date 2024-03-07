package org.dimasik666.customer.service;

import org.dimasik666.customer.domain.dto.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}
