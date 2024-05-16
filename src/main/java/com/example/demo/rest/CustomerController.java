package com.example.demo.rest;

import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerReview;
import com.example.demo.repository.Product;
import com.example.demo.service.CustomerReviewService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerReviewService customerReviewService;

    @GetMapping
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    Customer addCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/{customerId}/add-customer-review/{artisanId}")
    public CustomerReview addCustomerReviewToCustomer(
            @PathVariable Long customerId,
            @PathVariable Long artisanId,
            @RequestBody CustomerReview customerReview) {
        return customerService.addCustomerReviewToCustomer(customerId, artisanId, customerReview);
    }

    @PutMapping
    Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @PutMapping("update-review/{customerId}/{artisanId}/{customerReviewId}")
    CustomerReview updateCustomerReview(@PathVariable Long customerId,
                                        @PathVariable Long artisanId,
                                        @PathVariable Long customerReviewId,
                                        @RequestBody CustomerReview customerReview) {
        return customerService.updateCustomerReview(customerId, artisanId, customerReviewId, customerReview);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
