package com.dev.autoflex_back.service;

import com.dev.autoflex_back.dto.response.ProductionSuggestionResponse;

public interface ProductionService {
    ProductionSuggestionResponse calculateBestProduction();
}
