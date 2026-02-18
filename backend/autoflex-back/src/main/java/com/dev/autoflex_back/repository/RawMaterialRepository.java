package com.dev.autoflex_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.autoflex_back.entity.RawMaterial;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long>{
    boolean existsByCodeIgnoreCase(String code);
}
