package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;

public record ProductQuantityResponse(
    String productName, 
    int quantity, 
    BigDecimal unitPrice, 
    BigDecimal subtotal) {
}
