package com.example.orderassembly.service;

import com.example.orderassembly.model.Order;
import com.example.orderassembly.model.ProductShelfMapping;
import com.example.orderassembly.repository.OrderRepository;
import com.example.orderassembly.repository.ProductShelfMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductShelfMappingRepository productShelfMappingRepository;

    public List<Order> getOrdersByOrderNumbers(List<Long> orderNumbers) {
        return orderRepository.findByOrderNumberIn(orderNumbers);
    }

    public Map<String, List<Order>> getOrderInfoByOrderNumbers(List<Long> orderNumbers) {
        List<Order> orders = orderRepository.findByOrderNumberIn(orderNumbers);
        Map<String, List<Order>> orderInfoMap = new LinkedHashMap<>();
        for (Order order : orders) {
            ProductShelfMapping productShelfMapping = productShelfMappingRepository.findByProductId(order.getProduct().getId());
            String shelfName = productShelfMapping.getShelf().getName();
            if (!orderInfoMap.containsKey(shelfName)) {
                orderInfoMap.put(shelfName, new ArrayList<>());
            }
            orderInfoMap.get(shelfName).add(order);
        }
        return orderInfoMap;
    }
}
