package com.example.demo.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class CustomerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private int rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artisan_id")
    private Artisan artisan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
    }

    public CustomerReview() {
    }

    public CustomerReview(Long id, String description, int rating, Artisan artisan, Customer customer) {
        this.id = id;
        this.description = description;
        this.rating = rating;
        this.artisan = artisan;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
