package com.example.demo.rest;

import com.example.demo.repository.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    List<Order> getAllOrders() {
        return orderService.getOrder();
    }

    @GetMapping("/{id}")
    Order findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @PostMapping("/{customerId}/add-order/{productId}")
    Order addOrderToCustomer(@PathVariable Long customerId, @PathVariable Long productId, @RequestBody Order order) {
        return orderService.addOrderToCustomer(customerId, productId, order);
    }

    @PutMapping
    Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
