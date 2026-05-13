package se.productservicespring.app.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public record ProductRequestId(
        @JsonValue Long productId
) {
}
