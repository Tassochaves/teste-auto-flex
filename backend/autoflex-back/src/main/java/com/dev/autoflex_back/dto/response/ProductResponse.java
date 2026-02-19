package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;
import java.util.List;

import com.dev.autoflex_back.entity.Product;

public record ProductResponse(
    Long id,
    String code,
    String name,
    BigDecimal price,
    List<ProductMaterialsResponse> materials
) {

    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getCode(),
            product.getName(),
            product.getPrice(),
            product.getMaterials() != null ? product.getMaterials()
                        .stream()
                        .map(ProductMaterialsResponse::fromEntity)
                        .toList() : List.of()
        );
    }
}
