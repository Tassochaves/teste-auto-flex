package com.dev.autoflex_back.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.request.RawMaterialRequest;
import com.dev.autoflex_back.dto.response.RawMaterialResponse;
import com.dev.autoflex_back.entity.RawMaterial;
import com.dev.autoflex_back.repository.RawMaterialRepository;
import com.dev.autoflex_back.service.RawMaterialService;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialServiceImpl(RawMaterialRepository rawMaterialRepository){
        this.rawMaterialRepository = rawMaterialRepository;
    }

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
        if(rawMaterialRepository.existsByCodeIgnoreCase(request.code())){
            throw new RuntimeException("Raw Material code already exists: " + request.code());
        }

        RawMaterial material = RawMaterial.builder()
                .code(request.code())
                .name(request.name())
                .stockQuantity(request.stockQuantity())
                .build();

        return RawMaterialResponse.fromEntity(rawMaterialRepository.save(material));
    }

    @Override
    public RawMaterialResponse updateStock(Long id, BigDecimal newQuantity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
