package org.dimasik666.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.dimasik666.customer.domain.dto.CustomerRegistrationRequest;
import org.dimasik666.customer.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @RequestMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
        log.info("Register customer {}", request);
        customerService.registerCustomer(request);
    }
}
