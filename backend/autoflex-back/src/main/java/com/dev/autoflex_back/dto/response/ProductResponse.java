package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;
import com.dev.autoflex_back.entity.Product;

public record ProductResponse(
    Long id,
    String code,
    String name,
    BigDecimal price
) {

    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getCode(),
            product.getName(),
            product.getPrice()
        );
    }
}
