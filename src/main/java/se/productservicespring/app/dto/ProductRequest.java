package se.productservicespring.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductRequest(
        @JsonProperty("id")
        Long productId,
        String title,
        BigDecimal price,
        String description,
        String category,
        String image

) {
}
