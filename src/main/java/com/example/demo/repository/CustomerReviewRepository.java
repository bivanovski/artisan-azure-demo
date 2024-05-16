package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {
    CustomerReview findCustomerById(Long id);

    List<CustomerReview> findAllByOrderByIdAsc();
}
