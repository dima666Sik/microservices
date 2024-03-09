package org.dimasik666.clients.fraud.domain.dto;

import org.springframework.lang.NonNull;

public record FraudCheckResponse(
        @NonNull Boolean isFraudster) {
}
