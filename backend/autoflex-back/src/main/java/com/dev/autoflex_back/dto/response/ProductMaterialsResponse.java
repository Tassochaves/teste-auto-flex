package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;

import com.dev.autoflex_back.entity.ProductMaterials;

public record ProductMaterialsResponse(
    Long id,
    Long rawMaterialId,
    String rawMaterialName,
    BigDecimal quantity
) {

    public static ProductMaterialsResponse fromEntity(ProductMaterials productMaterials) {
        return new ProductMaterialsResponse(
            productMaterials.getId(),
            productMaterials.getRawMaterial().getId(),
            productMaterials.getRawMaterial().getName(),
            productMaterials.getRequiredQuantity()
        );
    }
}
