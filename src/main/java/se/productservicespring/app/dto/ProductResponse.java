package se.productservicespring.app.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        Long productId,
        BigDecimal price,
        String title,
        String description,
        String category,
        String image
) {
}
