package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;

import com.dev.autoflex_back.entity.RawMaterial;

public record RawMaterialResponse(
    Long id,
    String code,
    String name,
    BigDecimal stockQuantity
) {

    public static RawMaterialResponse fromEntity(RawMaterial material) {
        return new RawMaterialResponse(
            material.getId(),
            material.getCode(),
            material.getName(),
            material.getStockQuantity()
        );
    }
}
