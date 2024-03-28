package com.example.orderassembly.service;

import com.example.orderassembly.model.ProductShelfMapping;
import com.example.orderassembly.repository.ProductShelfMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductShelfMappingService {

    @Autowired
    private ProductShelfMappingRepository productShelfMappingRepository;

    public List<ProductShelfMapping> getAllProductShelfMappings() {
        return productShelfMappingRepository.findAll();
    }

    public ProductShelfMapping createProductShelfMapping(ProductShelfMapping productShelfMapping) {
        return productShelfMappingRepository.save(productShelfMapping);
    }

    public Long getShelfIdByProductId(Long productId) {
        ProductShelfMapping productShelfMapping = productShelfMappingRepository.findByProductId(productId);
        if (productShelfMapping != null) {
            return productShelfMapping.getShelf().getId();
        }
        return null;
    }
}