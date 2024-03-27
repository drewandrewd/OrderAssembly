package com.example.orderassembly.repository;

import com.example.orderassembly.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
