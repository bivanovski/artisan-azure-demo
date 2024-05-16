package com.example.demo.rest;

import com.example.demo.repository.CustomerReview;
import com.example.demo.service.CustomerReviewService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-review")
public class CustomerReviewController {

    @Autowired
    CustomerReviewService customerReviewService;

    @GetMapping
    List<CustomerReview> customerReviews() {
        return customerReviewService.getAllCustomerReviews();
    }

    @GetMapping("/{id}")
    CustomerReview findCustomerById(@PathVariable Long id) {
        return customerReviewService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerReviewService.deleteCustomer(id);
    }


}
