package com.example.orderassembly.controller;

import com.example.orderassembly.model.ProductShelfMapping;
import com.example.orderassembly.service.ProductShelfMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-shelf-mapping")
public class ProductShelfMappingController {

    @Autowired
    private ProductShelfMappingService productShelfMappingService;

    @GetMapping
    public List<ProductShelfMapping> getAllProductShelfMappings() {
        return productShelfMappingService.getAllProductShelfMappings();
    }

    @PostMapping
    public ProductShelfMapping createProductShelfMapping(@RequestBody ProductShelfMapping productShelfMapping) {
        return productShelfMappingService.createProductShelfMapping(productShelfMapping);
    }
}
