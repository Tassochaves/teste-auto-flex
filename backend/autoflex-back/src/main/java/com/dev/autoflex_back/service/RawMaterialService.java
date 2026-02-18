package com.dev.autoflex_back.service;

import java.math.BigDecimal;
import java.util.List;

import com.dev.autoflex_back.dto.request.RawMaterialRequest;
import com.dev.autoflex_back.dto.response.MessageResponse;
import com.dev.autoflex_back.dto.response.RawMaterialResponse;

public interface RawMaterialService {

    List<RawMaterialResponse> findAll();
    RawMaterialResponse findById(Long id);
    RawMaterialResponse create(RawMaterialRequest request);
    RawMaterialResponse updateStock(Long id, BigDecimal newQuantity);
    MessageResponse delete(Long id);
}
