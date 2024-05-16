package com.example.demo.service;

import com.example.demo.repository.CustomerReview;
import com.example.demo.repository.CustomerReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerReviewService {

    @Autowired
    CustomerReviewRepository customerReviewRepository;

    public List<CustomerReview> getAllCustomerReviews() {
        return customerReviewRepository.findAllByOrderByIdAsc();
    }

    public CustomerReview getCustomerById(Long id) {
        return customerReviewRepository.findCustomerById(id);
    }

    public void deleteCustomer(Long id) {
        customerReviewRepository.deleteById(id);
    }
}
