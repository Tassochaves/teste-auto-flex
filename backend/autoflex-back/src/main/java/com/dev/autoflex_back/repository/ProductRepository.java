package com.dev.autoflex_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.autoflex_back.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCodeIgnoreCase(String code);
    List<Product> findAllByOrderByPriceDesc();
}
