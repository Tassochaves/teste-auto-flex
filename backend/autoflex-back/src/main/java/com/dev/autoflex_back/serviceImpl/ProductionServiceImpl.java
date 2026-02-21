package com.dev.autoflex_back.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.autoflex_back.dto.response.ProductQuantityResponse;
import com.dev.autoflex_back.dto.response.ProductionSuggestionResponse;
import com.dev.autoflex_back.entity.Product;
import com.dev.autoflex_back.entity.ProductMaterials;
import com.dev.autoflex_back.entity.RawMaterial;
import com.dev.autoflex_back.repository.ProductRepository;
import com.dev.autoflex_back.repository.RawMaterialRepository;
import com.dev.autoflex_back.service.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService{

    private ProductRepository productRepository;
    private RawMaterialRepository rawMaterialRepository;

    public ProductionServiceImpl(ProductRepository productRepository, RawMaterialRepository rawMaterialRepository){
        this.productRepository = productRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @Override
    public ProductionSuggestionResponse calculateBestProduction() {

        List<Product> products = productRepository.findAllByOrderByPriceDesc();
        Map<Long, BigDecimal> virtualStock = loadVirtualStock();

        List<ProductQuantityResponse> suggestions = new ArrayList<>();
        BigDecimal grandTotal = BigDecimal.ZERO;

        for (Product product : products) {
            int quantityCanProduce = calculateMaxProduction(product, virtualStock);

            if (quantityCanProduce > 0) {
                BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantityCanProduce));
                
                suggestions.add(new ProductQuantityResponse(
                    product.getName(), quantityCanProduce, product.getPrice(), subtotal
                ));
                
                grandTotal = grandTotal.add(subtotal);
            }
        }

        return new ProductionSuggestionResponse(suggestions, grandTotal);
    }

    private int calculateMaxProduction(Product product, Map<Long, BigDecimal> stock) {
        int count = 0;
        while (hasMaterialsForOneUnit(product, stock)) {
            consumeMaterials(product, stock);
            count++;
        }
        return count;
    }

    private boolean hasMaterialsForOneUnit(Product product, Map<Long, BigDecimal> stock) {
        for (ProductMaterials item : product.getMaterials()) {
            BigDecimal available = stock.getOrDefault(item.getRawMaterial().getId(), BigDecimal.ZERO);
            if (available.compareTo(item.getRequiredQuantity()) < 0) {
                return false;
            }
        }
        return true;
    }

    private void consumeMaterials(Product product, Map<Long, BigDecimal> stock) {
        for (ProductMaterials item : product.getMaterials()) {
            Long id = item.getRawMaterial().getId();
            stock.put(id, stock.get(id).subtract(item.getRequiredQuantity()));
        }
    }

    private Map<Long, BigDecimal> loadVirtualStock() {
        return rawMaterialRepository.findAll().stream()
                .collect(Collectors.toMap(RawMaterial::getId, RawMaterial::getStockQuantity));
    }   

}
