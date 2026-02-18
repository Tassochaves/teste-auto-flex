package com.dev.autoflex_back.service;

import java.util.List;

import com.dev.autoflex_back.dto.request.ProductRequest;
import com.dev.autoflex_back.dto.response.MessageResponse;
import com.dev.autoflex_back.dto.response.ProductResponse;

public interface ProductService {

    List<ProductResponse> findAllSortedByPrice();
    ProductResponse findById(Long id);
    ProductResponse create(ProductRequest request);
    ProductResponse update(Long id, ProductRequest request);
    MessageResponse delete(Long id);
}
