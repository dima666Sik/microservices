package org.dimasik666.customer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dimasik666.clients.fraud.FraudClient;
import org.dimasik666.clients.fraud.domain.dto.FraudCheckResponse;
import org.dimasik666.customer.domain.dto.CustomerRegistrationRequest;
import org.dimasik666.customer.domain.model.Customer;
import org.dimasik666.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    @Transactional
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                                    .firstName(request.firstName())
                                    .lastName(request.lastName())
                                    .email(request.email())
                                    .build();
        log.info("Customer registered: {}", request);

        // todo: check if email valid
        // todo: check if email not taken

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        // todo: check if fraudster
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Customer is fraudster");
        }
    }
}
