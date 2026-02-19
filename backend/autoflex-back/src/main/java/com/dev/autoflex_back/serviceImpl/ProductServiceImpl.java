package com.dev.autoflex_back.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.request.ProductMaterialsRequest;
import com.dev.autoflex_back.dto.request.ProductRequest;
import com.dev.autoflex_back.dto.response.MessageResponse;
import com.dev.autoflex_back.dto.response.ProductResponse;
import com.dev.autoflex_back.entity.Product;
import com.dev.autoflex_back.entity.ProductMaterials;
import com.dev.autoflex_back.entity.RawMaterial;
import com.dev.autoflex_back.repository.ProductRepository;
import com.dev.autoflex_back.repository.RawMaterialRepository;
import com.dev.autoflex_back.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final RawMaterialRepository materialRepository;

    public ProductServiceImpl(ProductRepository productRepository, RawMaterialRepository materialRepository){
        this.productRepository = productRepository;
        this.materialRepository = materialRepository;
    }

    @Override
    public List<ProductResponse> findAllSortedByPrice() {

        return productRepository.findAllByOrderByPriceDesc().stream()
                    .map(ProductResponse::fromEntity)
                    .toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public ProductResponse create(ProductRequest request) {
        
        validateRequest(request);

        Product product = Product.builder()
            .code(request.code())
            .name(request.name())
            .price(request.price())
            .materials(new ArrayList<>())
            .build();

        for (ProductMaterialsRequest materialsRequest : request.materials()) {
            RawMaterial rawMaterial = materialRepository.findById(materialsRequest.rawMaterialId())
                            .orElseThrow(() -> new RuntimeException("Material not found: " + materialsRequest.rawMaterialId()));

            ProductMaterials productMaterials = ProductMaterials.builder()
                                .product(product)
                                .rawMaterial(rawMaterial)
                                .requiredQuantity(materialsRequest.quantity())
                                .build();
            
            product.getMaterials().add(productMaterials);
        }

        return ProductResponse.fromEntity(productRepository.save(product));
    }

    private void validateRequest(ProductRequest request) {
        if (request.materials() == null || request.materials().isEmpty()){
            throw new RuntimeException("Product must have at least one raw material");
        }
        if (productRepository.existsByCodeIgnoreCase(request.code())){
            throw new RuntimeException("Product code already exists: " + request.code());
        }
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public MessageResponse delete(Long id) {
       if(!productRepository.existsById(id)){
            throw new RuntimeException("Product not found");
       }

       productRepository.deleteById(id);
       return new MessageResponse("Product deleted successfully");
    }

}
