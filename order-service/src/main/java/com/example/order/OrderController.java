package com.example.order;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private Map<Long, Order> orders = new HashMap<>();
    private RestTemplate restTemplate = new RestTemplate();

    public OrderController() {
        orders.put(1L, new Order(1L, 1L, "Laptop", 999.99));
        orders.put(2L, new Order(2L, 2L, "Phone", 599.99));
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = orders.get(id);
        if (order == null) return null;

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        
        try {
            Object user = restTemplate.getForObject("http://localhost:8081/users/" + order.getUserId(), Object.class);
            response.put("user", user);
        } catch (Exception e) {
            response.put("user", "User service unavailable");
        }
        
        return response;
    }

    @GetMapping
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}