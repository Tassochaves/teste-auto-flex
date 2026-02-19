package com.dev.autoflex_back.dto.request;

import java.math.BigDecimal;

public record ProductMaterialsRequest(
    Long rawMaterialId,
    BigDecimal quantity
) {

}
