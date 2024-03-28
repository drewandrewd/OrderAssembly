package com.example.orderassembly;

import com.example.orderassembly.model.Order;
import com.example.orderassembly.service.OrderService;
import com.example.orderassembly.service.ProductShelfMappingService;
import com.example.orderassembly.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleApplication implements CommandLineRunner {

    private final OrderService orderService;
    private final ProductShelfMappingService productShelfMappingService;
    private final ShelfService shelfService;


    @Autowired
    public ConsoleApplication(OrderService orderService, ProductShelfMappingService productShelfMappingService, ShelfService shelfService) {
        this.orderService = orderService;
        this.productShelfMappingService = productShelfMappingService;
        this.shelfService = shelfService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номера заказов через пробел:");
        String[] orderNumbers = scanner.nextLine().split(" ");
        List<Long> orderNumberList = Arrays.stream(orderNumbers)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<Order> orders = orderService.getOrdersByOrderNumbers(orderNumberList);

        // Создаем Map для хранения продуктов по стеллажам
        Map<String, List<Order>> productsByShelves = new LinkedHashMap<>();
        for (Order order : orders) {
            Long productId = order.getProduct().getId();
            Long shelfId = productShelfMappingService.getShelfIdByProductId(productId);
            String shelfName = shelfService.getShelfNameById(shelfId);

            // Проверяем, есть ли уже такой стеллаж в Map
            if (!productsByShelves.containsKey(shelfName)) {
                productsByShelves.put(shelfName, new ArrayList<>());
            }

            // Добавляем продукт в список соответствующего стеллажа
            productsByShelves.get(shelfName).add(order);
        }

        // Выводим продукты по стеллажам
        for (Map.Entry<String, List<Order>> entry : productsByShelves.entrySet()) {
            System.out.println("===" + entry.getKey());
            for (Order order : entry.getValue()) {
                System.out.println(order.getProduct().getName() + " (id=" + order.getProduct().getId() + ")");
                System.out.println("заказ " + order.getOrderNumber() + ", " + order.getQuantity() + " шт");
                if (order.getAdditionalShelf() != null) {
                    System.out.println("доп стеллаж: " + order.getAdditionalShelf());
                }
                System.out.println();
            }
        }
    }
}
