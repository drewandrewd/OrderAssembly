package com.example.orderassembly.controller;

import com.example.orderassembly.model.Order;
import com.example.orderassembly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Map<String, List<Order>> getOrderInfoByOrderNumbers(@RequestParam List<Long> orderNumbers) {
        return orderService.getOrderInfoByOrderNumbers(orderNumbers);
    }
}
