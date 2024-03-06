package org.dimasik666.domain.dto;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
