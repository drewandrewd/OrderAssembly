package com.example.orderassembly.repository;

import com.example.orderassembly.model.ProductShelfMapping;
import com.example.orderassembly.model.ProductShelfMappingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductShelfMappingRepository extends JpaRepository<ProductShelfMapping, ProductShelfMappingId> {
    ProductShelfMapping findByProductId(Long productId);
}
