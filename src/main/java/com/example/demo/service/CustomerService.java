package com.example.demo.service;

import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerReviewRepository customerReviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ArtisanRepository artisanRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAllByOrderByIdAsc();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    public CustomerReview addCustomerReviewToCustomer(Long customerId, Long artisanId, CustomerReview customerReview) {
        // Find the customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

        // Find the artisan by ID
        Artisan artisan = artisanRepository.findById(artisanId).orElseThrow(() -> new IllegalArgumentException("Artisan with that ID cannot be found"));

        // Set the product and artisan for the customer review
        customerReview.setArtisan(artisan);

        // Add the customer review to the customer
        customerReview.setCustomer(customer);

        // Save the updated customer
        return customerReviewRepository.save(customerReview);

    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerReview updateCustomerReview(Long customerId, Long artisanId, Long customerReviewId, CustomerReview customerReview) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

        Artisan artisan = artisanRepository.findById(artisanId).orElseThrow(() -> new IllegalArgumentException("Artisan with that ID cannot be found"));

        CustomerReview existingReview = customerReviewRepository.findById(customerReviewId)
                .orElseThrow(() -> new IllegalArgumentException("Customer review not found"));


       existingReview.setDescription(customerReview.getDescription());
       existingReview.setRating(customerReview.getRating());

       return customerReviewRepository.save(existingReview);

    }
}
