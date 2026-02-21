package com.dev.autoflex_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.autoflex_back.dto.response.ProductionSuggestionResponse;
import com.dev.autoflex_back.service.ProductionService;

@RestController
@RequestMapping("/api/v1/production")
public class ProductionController {

    private ProductionService productionService;

    public ProductionController(ProductionService productionService){
        this.productionService = productionService;
    }

    @GetMapping("/suggestion")
    public ResponseEntity<ProductionSuggestionResponse> getSuggestion() {
        return ResponseEntity.ok(productionService.calculateBestProduction());
    }
}
