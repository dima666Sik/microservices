package org.dimasik666.controller;

import lombok.extern.slf4j.Slf4j;
import org.dimasik666.domain.dto.CustomerRegistrationRequest;
import org.dimasik666.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @RequestMapping("/register")
    public void registerCustomer(@RequestParam CustomerRegistrationRequest request){
        log.info("Register customer {}", request);
        customerService.registerCustomer(request);
    }
}
