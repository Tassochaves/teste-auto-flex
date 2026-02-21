package com.dev.autoflex_back.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record ProductionSuggestionResponse(
    List<ProductQuantityResponse> suggestions, 
    BigDecimal totalValue) {

}
