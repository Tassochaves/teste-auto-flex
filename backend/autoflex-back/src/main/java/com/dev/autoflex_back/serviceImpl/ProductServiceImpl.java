package com.dev.autoflex_back.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.request.ProductRequest;
import com.dev.autoflex_back.dto.response.ProductResponse;
import com.dev.autoflex_back.entity.Product;
import com.dev.autoflex_back.repository.ProductRepository;
import com.dev.autoflex_back.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

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
        
        if (productRepository.existsByCodeIgnoreCase(request.code())){
            throw new RuntimeException("Product code already exists: " + request.code());
        }

        Product product = new Product();
        product.setCode(request.code());
        product.setName(request.name());
        product.setPrice(request.price());

        return ProductResponse.fromEntity(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
