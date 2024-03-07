package org.dimasik666.customer.domain.dto;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
