package com.dev.autoflex_back.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.request.RawMaterialRequest;
import com.dev.autoflex_back.dto.response.RawMaterialResponse;
import com.dev.autoflex_back.service.RawMaterialService;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

    @Override
    public List<RawMaterialResponse> findAll() {
        return null;
    }

    @Override
    public RawMaterialResponse findById(Long id) {
        return null;
    }

    @Override
    public RawMaterialResponse create(RawMaterialRequest request) {
        return null;
    }

    @Override
    public RawMaterialResponse updateStock(Long id, BigDecimal newQuantity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
