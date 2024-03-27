package com.example.orderassembly.repository;

import com.example.orderassembly.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderNumberIn(List<Long> orderNumbers);
}
