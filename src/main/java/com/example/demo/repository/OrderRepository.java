package com.example.demo.repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order getOrderById(Long id);

    List<Order> findAllByOrderByIdAsc();
}
