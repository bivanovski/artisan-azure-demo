package com.example.demo.service;

import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Order> getOrder() {
        return orderRepository.findAllByOrderByIdAsc();
    }

    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public Order addOrderToCustomer(Long customerId, Long productId, Order order) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));

        // Associate the product with the order
        order.getProducts().add(product);

        // Set the customer for the order
        order.setCustomer(customer);

        // Save the order
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
