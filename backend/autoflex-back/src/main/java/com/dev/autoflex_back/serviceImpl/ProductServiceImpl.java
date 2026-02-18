package com.dev.autoflex_back.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.request.ProductRequest;
import com.dev.autoflex_back.dto.response.ProductResponse;
import com.dev.autoflex_back.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public List<ProductResponse> findAllSortedByPrice() {

        return null;
    }

    @Override
    public ProductResponse findById(Long id) {
        return null;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        return null;
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
