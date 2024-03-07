package org.dimasik666.customer.domain.dto;

import org.springframework.lang.NonNull;

public record FraudCheckResponse(
        @NonNull Boolean isFraudster) {
}
