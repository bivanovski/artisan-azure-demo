package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(Long id);

    List<Customer> findAllByOrderByIdAsc();
}
