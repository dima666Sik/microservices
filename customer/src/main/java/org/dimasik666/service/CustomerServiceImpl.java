package org.dimasik666.service;

import lombok.extern.slf4j.Slf4j;
import org.dimasik666.domain.dto.CustomerRegistrationRequest;
import org.dimasik666.domain.model.Customer;
import org.dimasik666.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerServiceImpl(CustomerRepository customerRepository)
        implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                                    .firstName(request.firstName())
                                    .lastName(request.lastName())
                                    .email(request.email())
                                    .build();
        log.info("Customer registered: {}", request);
        customerRepository.save(customer);
    }
}
